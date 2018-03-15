package com.hao.ssm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hao.ssm.common.Result;
import com.hao.ssm.common.ResultGenerator;
import com.hao.ssm.pojo.Items;
import com.hao.ssm.pojo.PageBean;
import com.hao.ssm.service.ItemsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : hao
 * @description : 订单的Controller
 * @time : 2018/3/12 13:33
 */
@RestController
@RequestMapping("/items")
public class ControllerItems {

    @Autowired
    private ItemsService itemsService;
    private static final Logger log = Logger.getLogger(ControllerItems.class);

    /**
     * restful 风格的请求
     *
     * @param name
     * @return
     */
    @GetMapping("/queryList/{name}")
    public List<Items> queryOrderList(@PathVariable(value = "name") String name) {

        List<Items> items = itemsService.findItemsListByName(name);

        if (items.size() == 0) {
            return new ArrayList<Items>(1);
        }
        return items;
    }

    @PostMapping("/queryByMap")
    public PageBean query(@RequestParam Map<String, String> map) {
        PageHelper.startPage(Integer.valueOf(map.get("page")), Integer.valueOf(map.get("rows")));
        List<Items> items = itemsService.findItemsListByName(map.get("name"));
        if (items.size() == 0) {
            return new PageBean(0, new ArrayList());
        }
        PageInfo<Items> pageInfo = new PageInfo<Items>(items);
        PageBean<Items> pageBean = new PageBean<Items>(pageInfo.getTotal(), pageInfo.getList());
        return pageBean;
    }

    @PostMapping("/queryByObj")
    public PageBean queryByObj(Items items) {
        log.debug("怎么不打印日志呢");
        PageHelper.startPage(items.getPage(), items.getRows());
        List<Items> list = itemsService.findItemsListByName(items.getName());
        if (list.size() == 0) {
            return new PageBean(0, new ArrayList());
        }
        PageInfo<Items> pageInfo = new PageInfo<Items>(list);
        PageBean<Items> pageBean = new PageBean<Items>(pageInfo.getTotal(), pageInfo.getList());
        return pageBean;
    }

/*    @RequestMapping("/queryListByPage")
    @AnnoLog(operationType="查询商品列表分页")
    public @ResponseBody
    PageBean<Items> findItemsListByPage(ItemsCustom itemsCustom){

        PageHelper.startPage(itemsCustom.getPage(),itemsCustom.getRows());
        List<Items> items = itemsService.findItemsListByPage(itemsCustom);
        if(items.size()==0){
            return new PageBean(0,new ArrayList());
        }
        PageInfo<Items> pageInfo = new PageInfo<Items>(items);

        PageBean<Items> pageBean = new PageBean<Items>(pageInfo.getTotal(),pageInfo.getList());
        return pageBean;
    }
*/


    @PostMapping("/addItem")
    public Result addOrderItem(Items items) {
        Integer lastId = itemsService.addOrderItem(items);
        if (lastId == null) {
            return ResultGenerator.genFailResult("error");
        }
        return ResultGenerator.genSuccessResult(lastId);
    }
}
