package com.suncaper.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.Constant;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.common.SessionUtils;
import com.suncaper.demo.entity.*;
import com.suncaper.demo.entity.dto.ProductDTO;
import com.suncaper.demo.mapper.ProductMapper;
import com.suncaper.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SkuService skuService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private BatchService batchService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private StockService stockService;
    @Override
    public void insert(ProductDTO product, List<Image> images) {

        productMapper.myInsert(product);
        //添加编码
        List<String> skuName=product.getSkuName();
        List<Sku> skus = skuName.stream().map(x -> {
            Sku sku = new Sku();
            sku.setProductId(product.getId());
            sku.setName(x);
            return sku;
        }).collect(Collectors.toList());
        skuService.batchInsert(skus);
        //+同添加总量 和初始化库存数量
        List<String> skuName1 = product.getSkuName();
        List<Stock> stocks = skuName1.stream().map(x->{
            //x是skuname
            Stock stock = new Stock();
            stock.setBatchId(product.getBatchId());
            stock.setProductId(product.getId());
            //根据skuname 找到 id 把 id 和stock关联
            stock.setSkuId(skuService.selectIdByName(x,product.getId()));
            stock.setSkuName(x);
            return stock;
        }).collect(Collectors.toList());
        //插入库存总量
        stockService.insert(stocks);
        //每个编码 库存和总量都更新
        List<Integer> skuTotal = product.getSkuTotal();
        for(int i = 0;i<skuTotal.size();i++){
            Stock stock = new Stock();
            stock.setSkuName(skuName.get(i));
            stock.setSkuTotal(skuTotal.get(i));
            stock.setCurStock(skuTotal.get(i));
            stockService.updateStock(stock);
        }
        //插入图片
        images.stream().forEach(x->{
            x.setProductId(product.getId());
        });

        imageService.insert(images);

    }

    @Override
    public PageInfo<Product> list(ProductDTO product) {
        //分页初始化
        if(product.getPageNum()==null&&product.getPageSize()==null){
            product.setPageNum(Constant.PAGENUM_INIT);
            product.setPageSize(Constant.PAGESIZE_INIT);
        }
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria =example.createCriteria();
        criteria.andIsDeletedEqualTo(Constant.IS_DELETED_0==0);
        example.setOrderByClause("id desc");
        PageHelper.startPage(product.getPageNum(),product.getPageSize());
        List<Product> products =productMapper.selectByExample(example);
       //将图片和规格包装到product里
        products.stream().forEach(x->{
            x.setImages(imageService.listByProductId(x.getId()));
            x.setSkus(skuService.listByProductId(x.getId()));
        });
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    @Override
    public JsonResult deleteById(Long id) {
        Product pro = productMapper.selectByPrimaryKey(id);
        Batch batch = batchService.selectByPrimaryKey(pro.getBatchId());
        LocalDate registerStartDate = batch.getRegisterStartDate();
        LocalDate now = LocalDate.now();
        if(now.isBefore(registerStartDate)){
            Product product = new Product();
            product.setId(id);
            product.setIsDeleted(true);
            productMapper.updateByPrimaryKeySelective(product);
            return JsonResult.ok(true);
        }
        return JsonResult.ok(false);
    }

    @Override
    public JsonResult selectById(Long id) {
        Product product = productMapper.selectByPrimaryKey(id);
        product.setImages(imageService.listByProductId(product.getId()))
                .setSkus(skuService.listByProductId(product.getId()))
                .setBatch(batchService.selectByPrimaryKey(product.getBatchId()))
                .setSexValue(dictionaryService.getNameByTypeAndValue(Constant.GENDER_TYPE,product.getGender()))
                .setGradeName(gradeService.selectByBatchId(product.getBatchId()))
                .setStocks(stockService.listByProductId(product.getId()));

        return JsonResult.ok(product);
    }

    @Override
    public void update(ProductDTO product, List<Image> collect) {
        //多表关联修改---先删除再添加
        //先把对应规格图片删除
        SkuExample skuExample = new SkuExample();
        skuExample.createCriteria().andProductIdEqualTo(product.getId());
        skuService.deleteByExample(skuExample);
        ImageExample imgExample = new ImageExample();
        imgExample.createCriteria().andProductIdEqualTo(product.getId());
        imageService.deleteByExample(imgExample);
        //更新新的数据
        productMapper.updateByPrimaryKeySelective(product);
        //更新关联的表
        List<String> skuName=product.getSkuName();
        List<Sku> skus = skuName.stream().map(x -> {
            Sku sku = new Sku();
            sku.setProductId(product.getId());
            sku.setName(x);
            return sku;
        }).collect(Collectors.toList());
        //添加编码
        skuService.batchInsert(skus);
        //插入新图片
        collect.stream().forEach(x->x.setProductId(product.getId()));
        imageService.insert(collect);
        //oldImg
        List<String> oldImg = product.getOldImg();
        List<Image> oldImgs = oldImg.stream().map(x -> {
            Image image = new Image();
            image.setProductId(product.getId());
            image.setPath(x);
            image.setName("");
            return image;
        }).collect(Collectors.toList());

        imageService.insert(oldImgs);
    }

    @Override
    public PageInfo<Product> myList(ProductDTO productDTO) {
        //根据当前用户查询能够看得的衣服
        //最新批次同时要符合自己的性别
        Batch curBatch = batchService.getCurBatch();
        User curUser = SessionUtils.getCurUser();
        //获取性别
        Student student = studentService.selectByUser(curUser);
        String sex = Constant.GENDER_MALE.equals(student.getGender())?Constant.GENDER_MAN:Constant.GENDER_FAMAN;
        ProductExample example = new ProductExample();
        //把MF加入sex中
        List<String> genders = Arrays.asList(sex, Constant.GENDER_MAN_AND_FAMAN);
        example.createCriteria().andBatchIdEqualTo(curBatch.getId()).andGenderIn(genders);
        //分页初始化
        if((productDTO.getPageNum()==null||productDTO.getPageNum()<0)||(productDTO.getPageSize()==null||productDTO.getPageSize()<0)){
            productDTO.setPageNum(Constant.PAGENUM_INIT);
            productDTO.setPageSize(Constant.PAGESIZE_INIT);
        }
        PageHelper.startPage(productDTO.getPageNum(),productDTO.getPageSize());
        List<Product> products = productMapper.selectByExample(example);
        PageInfo<Product> pageInfo = new PageInfo<>(products) ;
        products.stream().forEach(x->{
            x.setImages(imageService.listByProductId(x.getId()));
            x.setSkus(skuService.listByProductId(x.getId()));
        });
        return pageInfo;
    }

}
