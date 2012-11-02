nutz-plugin
===========

nutz的插件集合

1.  coc：约定大于配置插件， 可以自动将controller映射为url
    映射规则： controllers/moduleName/controllerName.java, 映射为 /modelName/controllerName/actionName，
    映射的视图为 WEB-INF/templates/modelName/controllerName/actionName.jsp
    方法为 public的，会排除Object的方法和set、get方法，其他的全部会全部进行映射，若不想使用默认映射，直接采用@At()
    自定义即可
2.  flash.message： 使重定向操作可以传递参数，在重定向页面使用${flash.message}即可引用传递的参数
3.  ncode： 代码生成器，可以直接生成project、controller、view，也可以自己对这些进行定制，完全随心所欲。
4.  scoffolding： coc的脚手架，只要在controller中添加scoffolding开关即可动态生成CRUD方法和view， view可以定制
    如果不满意动态生成的crud方法，直接在controller中自己写一个同名方法即可，需要同时写相应的view