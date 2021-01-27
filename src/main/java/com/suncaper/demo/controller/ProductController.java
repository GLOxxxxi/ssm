package com.suncaper.demo.controller;

import com.github.pagehelper.PageInfo;
import com.suncaper.demo.common.JsonResult;
import com.suncaper.demo.entity.Image;
import com.suncaper.demo.entity.Product;
import com.suncaper.demo.entity.dto.ProductDTO;
import com.suncaper.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("toAdd")
    public String toAdd() {
        return "productAdd";
    }

    /**
     * 多文件上传
     *
     * @param request
     * @param file
     * @param product
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(HttpServletRequest request, MultipartFile[] file, ProductDTO product) throws IOException {

        String realPath = request.getServletContext().getRealPath("static/img");
        File fileImg = new File(realPath);
        if (!fileImg.exists()) {
            fileImg.mkdir();
        }
        List<Image> collect = Stream.of(file)
                .filter(x -> x.getOriginalFilename() != null && !"".equals(x.getOriginalFilename()))
                .map(x -> {
                    String path = UUID.randomUUID().toString() + x.getOriginalFilename();
                    File fileUp = new File(realPath + "/" + path);
                    if (!fileUp.exists()) {
                        try {
                            fileUp.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            x.transferTo(fileUp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    Image image = new Image();
                    image.setPath(path);
                    image.setName(x.getOriginalFilename());
                    return image;

                }).collect(Collectors.toList());

        productService.insert(product, collect);
        return "redirect:/product/list";
    }

    @RequestMapping("list")
    public String list (ProductDTO product, Model model){
        PageInfo<Product> pageInfo= productService.list(product);
        model.addAttribute("pageInfo",pageInfo);
        return "productList";
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public JsonResult deleteById(Long id){
        return productService.deleteById(id);
    }

    @RequestMapping("selectById")
    @ResponseBody
    public JsonResult selectById(Long id){
        return productService.selectById(id);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(HttpServletRequest request, MultipartFile[] file, ProductDTO product) throws IOException {
        String realPath = request.getServletContext().getRealPath("static/img");
        File fileImg = new File(realPath);
        if (!fileImg.exists()) {
            fileImg.mkdir();
        }
        List<Image> collect = Stream.of(file)
                .filter(x -> x.getOriginalFilename() != null && !"".equals(x.getOriginalFilename()))
                .map(x -> {
                    String path = UUID.randomUUID().toString() + x.getOriginalFilename();
                    File fileUp = new File(realPath + "/" + path);
                    if (!fileUp.exists()) {
                        try {
                            fileUp.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            x.transferTo(fileUp);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    Image image = new Image();
                    image.setPath(path);
                    image.setName(x.getOriginalFilename());
                    return image;

                }).collect(Collectors.toList());

        productService.update(product, collect);
        return "forward:/product/list";
    }

    @RequestMapping("myList")
    public String myList(Model model,ProductDTO productDTO){
        PageInfo<Product> pageInfo = productService.myList(productDTO);
        model.addAttribute("pageInfo",pageInfo);
        return "myProductList";

    }


}

