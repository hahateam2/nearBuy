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
```
参数列表
{
    goodsid:（所属商品id）
    imageFiles：（图片文件，支持同时上传多张图片）
    type:（对每张图片，都有一个类型描述，如"物品"对应物品的真实图片，"详情"对应物品的详情图片，参见淘宝）
}
```
#### 通过主键修改商品图片
PUT http://127.0.0.1:8080/nearstBuy_war/Goodsimage/Goods/
#### 通过主键删除商品图片
DELETE http://127.0.0.1:8080/nearstBuy_war/Goodsimage/Goods/{id}
#### 分页获取商品图片列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Goodsimage/{page}/{pagesize}
#### 获取 指定商品 指定类型 的图片列表
GET http://127.0.0.1:8080/nearstBuy_war/mobile/Goodsimage/goods/{goodsid}/{type}


### 商品视频

#### 通过id查询商品视频
GET http://127.0.0.1:8080/nearstBuy_war/mobile/GoodsVideo/{id}
#### 增加商品
POST http://127.0.0.1:8080/nearstBuy_war/mobile/GoodsVideo/
```
参数列表
{
    goodsid:（所属商品id）
    videoFiles：（视频文件，支持同时上传多个视频）
}
```
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


### 需求

#### 通过id查询需求
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/{id}
#### 增加需求
POST http://127.0.0.1:8080/nearstBuy_war/mobile/need/
```
发送参数列表(例)
{
userid:ce14098412814a4da9e5c3a720c04b31 （用户id）
name:篮球 （需求物品的名字）
depict:需要一个篮球，要求不多，能打就行 (对需求物品的描述)
addressid:315646461316846945165 （地址信息id）
}
```
#### 通过主键修改需求
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/need/
#### 通过主键删除需求
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/need/{id}

#### 获取全部需求列表，分页    
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/{page}/{count}

参数说明：(page：指定第几页，page=0 时查询所有不分页；count:指定每页记录的条数。下同)

#### 通过关键字查询需求列表，分页 
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/search/{word}/{page}/{count}

参数说明：(word：要查询的关键字)

#### 获取指定用户的全部需求列表，分页   
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/user/{userId}/{page}/{count}

参数说明：(userId：用户id，下同)

#### 获取指定用户的指定状态的需求列表，分页
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/user/{userId}/{status}/{page}/{count}

参数说明：(status：需求的状态，有以下几种：需求：需求中；暂停：暂停中；完成：已完成；封禁：被管理员封禁）

#### 复合查询：关键字、用户、状态 三个条件（可空，可任意组合），分页
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/query/
```
发送参数列表(例)
{
userid:ce14098412814a4da9e5c3a720c04b31 （用户id）
name:篮球 （要查询的关键字）
status：需求
page: 1 （查询指定页的记录，如不分页则不需要此参数）
pageRows：5 (指定每页的记录条数，如不分页则不需要此参数，当指定page而不指定pageRows时，服务器默认每页10条记录)
}
```
例：
```
查询所有，无条件，不分页：
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/query/
查询所有，无条件，分页：
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/query/?page=1&pageRows=5

关键字查询：
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/query/？name=乒乓
关键字查询，分页：
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/query/？name=乒乓&page=1&pageRows=5

查询 指定用户 所有需求：
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/query/？userid=484971626
查询 指定用户 指定状态 的需求：
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/query/？userid=484971626&status=需求

查询 指定用户 指定状态 带关键字 的需求：
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/query/？userid=484971626&status=需求&name=乒乓
```

#### 复合查询记录的数量：关键字、用户、状态 三个条件（可空，可任意组合），分页
GET http://127.0.0.1:8080/nearstBuy_war/mobile/need/count/

发送参数及规则 同上 的 复合查询


### 捐赠

#### 通过id查询捐赠
GET http://127.0.0.1:8080/nearstBuy_war/mobile/donate/{id}
#### 增加捐赠
POST http://127.0.0.1:8080/nearstBuy_war/mobile/donate/
```
发送参数(例)
{
userid:ce14098412814a4da9e5c3a720c04b31 （用户id）
name:篮球
depict:捐一个篮球，不是多好，但能打 (对捐赠物品的描述)
addressid:315646461316846945165 （地址信息id）
}
```
#### 通过主键修改捐赠
PUT http://127.0.0.1:8080/nearstBuy_war/mobile/donate/
#### 通过主键删除捐赠
DELETE http://127.0.0.1:8080/nearstBuy_war/mobile/donate/{id}

#### 获取全部捐赠列表，分页    
GET http://127.0.0.1:8080/nearstBuy_war/mobile/donate/{page}/{count}

#### 通过关键字查询捐赠列表，分页 
GET http://127.0.0.1:8080/nearstBuy_war/mobile/donate/search/{word}/{page}/{count}

#### 获取指定用户的全部捐赠列表，分页   
GET http://127.0.0.1:8080/nearstBuy_war/mobile/donate/user/{userId}/{page}/{count}

#### 获取指定用户的指定状态的捐赠列表，分页
GET http://127.0.0.1:8080/nearstBuy_war/mobile/donate/user/{userId}/{status}/{page}/{count}

参数说明：(status：捐赠的状态，有以下几种：捐赠：捐赠中；暂停：暂停中；完成：已完成；封禁：被管理员封禁）

#### 复合查询：关键字、用户、状态 三个条件（可空，可任意组合），分页
GET http://127.0.0.1:8080/nearstBuy_war/mobile/donate/query/
```
发送参数(例)
{
userid:ce14098412814a4da9e5c3a720c04b31 （用户id）
name:篮球 （要查询的关键字）
status：捐赠
}
```
参数规则同上

#### 复合查询记录的数量：关键字、用户、状态 三个条件（可空，可任意组合），分页
GET http://127.0.0.1:8080/nearstBuy_war/mobile/donate/count/

发送参数 同上 的 复合查询
