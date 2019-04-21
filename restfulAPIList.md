# 就近买 APP端 API列表

## restful API 列表

### 商品

#### 通过id查询商品

GET http://127.0.0.1:8080/nearstBuy_war/mobile/Goods/{id}

例：


GET http://127.0.0.1:8080/nearstBuy_war/mobile/Goods/b452ecff9fb94499a508fcfc3f8269f3
```
{
    "status": true,
    "msg": "查询数据成功",
    "data": {
        "id": "b452ecff9fb94499a508fcfc3f8269f3",
        "userid": null,
        "name": "皮球",
        "price": null,
        "stock": null,
        "tradewayid": null,
        "depict": null,
        "explain": null,
        "type": null,
        "createtime": 1555252043171,
        "status": null
    }
}
```
#### 增加商品
POST http://127.0.0.1:8080/nearstBuy_war/mobile/Goods/
```
参数
{
name:篮球
price:63
userid:ce14098412814a4da9e5c3a720c04b31
stock:6
}
```
```
{
    "status": true,
    "msg": "插入数据成功",
    "data": true
}

```
#### 分页获取商品列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Goods/{page}/{pagesize}

例：

GET http://127.0.0.1:8080/nearstBuy_war/mobile/Goods/1/2

```
{
    "status": true,
    "msg": "查询数据成功",
    "data": [
        {
            "data": [
                {
                    "id": "123123",
                    "userid": null,
                    "name": "水杯",
                    "price": null,
                    "stock": null,
                    "tradewayid": null,
                    "depict": null,
                    "explain": null,
                    "type": null,
                    "createtime": 1555392864000,
                    "status": null
                },
                {
                    "id": "13372421277102475",
                    "userid": null,
                    "name": "手机壳",
                    "price": null,
                    "stock": null,
                    "tradewayid": null,
                    "depict": null,
                    "explain": null,
                    "type": null,
                    "createtime": 1555575533000,
                    "status": null
                }
            ],
            "totalPage": 5,
            "page": 1
        }
    ]
}

```


#### 通过主键修改商品
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/Goods/

```
参数
{
name:篮球
price:63
id:1a16095cd82d4ce89f0f23a2c4338c59
}
```
```
{
    "status": true,
    "msg": "更新数据成功",
    "data": true
}

```
#### 通过主键删除商品
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/Goods/{id}

例：
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/Goods/1a16095cd82d4ce89f0f23a2c4338c59

```
{
    "status": true,
    "msg": "删除数据成功",
    "data": true
}

```

### 地址

#### 通过id查询地址
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Address/{id}
#### 增加地址
POST http://127.0.0.1:8080/nearstBuy_war/mobile/Address/
#### 通过主键修改地址
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/Address/
#### 通过主键删除地址
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/Address/{id}
#### 分页获取地址列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Address/{page}/{pagesize}

### 收藏

#### 通过id查询收藏
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Collection/{id}
#### 增加收藏
POST http://127.0.0.1:8080/nearstBuy_war/mobile/Collection/
#### 通过主键修改收藏
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/Collection/
#### 通过主键删除收藏
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/Collection/{id}
#### 分页获取收藏列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Collection/{page}/{pagesize}



### 评论

#### 通过id查询评论
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Comment/{id}
#### 增加评论
POST http://127.0.0.1:8080/nearstBuy_war/mobile/Comment/
#### 通过主键修改评论
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/Comment/
#### 通过主键删除评论
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/Comment/{id}
#### 分页获取评论列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Comment/{page}/{pagesize}



### 商品图片

#### 通过id查询商品图片
GET http://127.0.0.1:8080/nearstBuy_war/Goodsimage/Goods/{id}
#### 增加商品图片
POST http://127.0.0.1:8080/nearstBuy_war/Goodsimage/Goods/
#### 通过主键修改商品图片
PUT http://127.0.0.1:8080/nearstBuy_war/Goodsimage/Goods/
#### 通过主键删除商品图片
DELETE http://127.0.0.1:8080/nearstBuy_war/Goodsimage/Goods/{id}
#### 分页获取商品图片列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Goodsimage/{page}/{pagesize}



### 商品视频

#### 通过id查询商品视频
GET http://127.0.0.1:8080/nearstBuy_war/mobile/GoodsVideo/{id}
#### 增加商品
POST http://127.0.0.1:8080/nearstBuy_war/mobile/GoodsVideo/
#### 通过主键修改商品视频
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/GoodsVideo/
#### 通过主键删除商品视频
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/GoodsVideo/{id}
#### 分页获取商品视频列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/GoodsVideo/{page}/{pagesize}



### 订单

#### 通过id查询订单
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Order/{id}
#### 增加订单
POST http://127.0.0.1:8080/nearstBuy_war/mobile/Order/
#### 通过主键修改订单
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/Order/
#### 通过主键删除订单
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/Order/{id}
#### 分页获取订单列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Order/{page}/{pagesize}



### 点赞

#### 通过id查询点赞
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Praise/{id}
#### 增加点赞
POST http://127.0.0.1:8080/nearstBuy_war/mobile/Praise/
#### 通过主键修改点赞
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/Praise/
#### 通过主键删除点赞
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/Praise/{id}
#### 分页获取点赞列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Praise/{page}/{pagesize}


### 用户

#### 通过id查询用户
GET http://127.0.0.1:8080/nearstBuy_war/mobile/User/{id}
#### 增加用户
POST http://127.0.0.1:8080/nearstBuy_war/mobile/User/
#### 通过主键修改用户
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/User/
#### 通过主键删除用户
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/User/{id}
#### 分页获取用户列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/User/{page}/{pagesize}
