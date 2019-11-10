package com.luxin.springboot01.controller;

import com.luxin.springboot01.entity.PageBean;
import com.luxin.springboot01.entity.Product;
import com.luxin.springboot01.mapper.ProductMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductMapper productMapper;

    //根据条件查询商品
    @RequestMapping("/get_products")
    public Map getProducts(String name,int page,int rows){
        List<Product> products = new ArrayList<>();
        PageBean pb = new PageBean(page, rows);
        Map map = new HashMap();
        if(name==null || name==""){
            products = productMapper.getProducts(pb.getFirstPage(), pb.getRows());
            int total = productMapper.getCount();
            map.put("rows",products);
            map.put("total",total);
            return map;
        }else{
            products = productMapper.getProductsByName(pb.getFirstPage(),pb.getRows(),name);
            int total = productMapper.getCountByName(name);
            map.put("rows",products);
            map.put("total",total);
            return map;
        }
    }

    //添加商品
    @RequestMapping("/save_product")
    public int save_product(Product product){
        return productMapper.saveProduct(product);
    }

    //修改商品
    @RequestMapping("/update_product")
    public Object updateProduct(Product product){
        Map<String,Object> map = new HashMap<>();
        try {
            if (productMapper.updateProduct(product) == 1) {
                map.put("success", true);
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("errorMsg","修改失败!");
        }
        return map;
    }

    //删除商品
    @RequestMapping("/del_product")
    public Object del_Product(int id){
        Map<String,Object> map = new HashMap<>();
        try {
            if (productMapper.delProduct(id) == 1) {
                map.put("success", true);
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("errorMsg","删除失败!");
        }
        return map;
    }

    //商品入库
    @RequestMapping("/add_product_num")
    public Object addProductNum(int id, int num, int changeNum){
        int allNum = num + changeNum;
        Map<String,Object> map = new HashMap<>();
        try {
            if (productMapper.updateProductNum(id, allNum) == 1) {
                map.put("success", true);
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("errorMsg","入库失败!");
        }
        return map;
    }

    //商品出库
    @RequestMapping("/remove_product_num")
    public Object removeProductNum(int id, int num, int changeNum){
        Map<String,Object> map = new HashMap<>();
        int allNum = num - changeNum;
        if(allNum < 0){
            map.put("success",false);
            map.put("errorMsg","出库失败!");
            return map;
        }
        try {
            if (productMapper.updateProductNum(id, allNum) == 1) {
                map.put("success", true);
            }
        } catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("errorMsg","出库失败!");
        }
        return map;
    }

}