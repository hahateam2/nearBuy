# FreeMaker Demo

1，java代码

```
@RequestMapping(value = "/",method = RequestMethod.GET)
public String index(Model model) {
    model.addAttribute("name","用户");
    return "PCfront/index";
}
```

2,Html 模板编写

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>首页</title>
</head>
<body>
<h1>欢迎来到就近卖 APP</h1>

<h2> ${name}管理页面</h2>
</body>
</html>
```



