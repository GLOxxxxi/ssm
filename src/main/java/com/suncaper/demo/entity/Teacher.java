package com.suncaper.demo.entity;

public class Teacher {
    private String username;

    private String usersn;

    private Long organizationid;

    private String organizationname;

    private String organizationsn;

    private Long roleid;

    private String rolename;

    private Byte organizationtype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsersn() {
        return usersn;
    }

    public void setUsersn(String usersn) {
        this.usersn = usersn == null ? null : usersn.trim();
    }

    public Long getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Long organizationid) {
        this.organizationid = organizationid;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }

    public String getOrganizationsn() {
        return organizationsn;
    }

    public void setOrganizationsn(String organizationsn) {
        this.organizationsn = organizationsn == null ? null : organizationsn.trim();
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Byte getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(Byte organizationtype) {
        this.organizationtype = organizationtype;
    }
}