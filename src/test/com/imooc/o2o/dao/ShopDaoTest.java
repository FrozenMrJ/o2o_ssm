package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopListAndCount(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(3L);
        shopCondition.setOwner(owner);
        shopCondition.setShopCategory(shopCategory);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 2);
        System.out.println("店铺列表的大小" + shopList.size());
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("总数：" + count);
    }

    @Test
    public void testQueryByShopId(){
        long shopId = 1L;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId = " + shop.getArea().getAreaId());
        System.out.println("areaName = " + shop.getArea().getAreaName());
    }

    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(2L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺2");
        shop.setShopDesc("test2");
        shop.setShopAddr("test2");
        shop.setPhone("test2");
        shop.setShopImg("test2");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
//        Assert.assertEquals(1,effectedNum);
    }
    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        Assert.assertEquals(1,effectedNum);
    }
}
