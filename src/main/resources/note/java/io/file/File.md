## File类详解

### 1. 概念

* 在 Java 中，File 类是 java.io 包中唯一代表磁盘文件本身的对象。File 类定义了一些与平台无关的方法来操作文件，File类主要用来获取或处理与磁盘文件相关的信息，像文件名、
  文件路径、访问权限和修改日期等，还可以浏览子目录层次结构。
* File 类表示处理文件和文件系统的相关信息。也就是说，File 类不具有从文件读取信息和向文件写入信息的功能，它仅描述文件本身的属性。

### 2. 构造器与方法

1. 构造方法

* File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
* File(String parent,String child) 根据指定的父路径和文件路径创建一个新File对象实例
* File(File parent,String child) 根据指定的父路径对象和文件路径创建一个新的File对象实例

2. 常用方法
    1. File类创建和删除功能
        * boolean createNewFile();指定路径不存在该文件时创建文件，返回true 否则false
        * boolean mkdir（） 当指定的单击文件夹不存在时创建文件夹并返回true 否则false
        * boolean mkdirs（） 但指定的多级文件夹在某一级文件夹不存在时，创建多级文件夹并返回true 否则false
        * boolean delete（） 删除文件或者删除单级文件夹，删除文件夹，这个文件夹下面不能有其他的文件和文件夹

    2. File类的判断功能
        * boolean exists() 判断指定路径的文件或文件夹是否为空
        * boolean isAbsolute() 判断当前路径是否是绝对路径
        * boolean isDirectory() 判断当前的目录是否存在
        * boolean isFile() 判断当前的目录是否是一个文件
        * boolean isHidden() 判断当前路径是否是一隐藏文件

    3. File类的获取功能和修改名字功能
        * File getAbsoluteFile() 获取文件的绝对路径，返回File对象
        * String getAbsolutePath() 获取文件的绝对路径，返回路径的字符串
        * String getParent() 获取当前路径的父级路径，以字符串形式返回该父级路径
        * String getName() 获取文件或文件夹的名称
        * String getPath() 获取File对象中封装的路径
        * long lastModified() 以毫秒值返回最后修改时间
        * long length() 返回文件的字节数
        * boolean renameTo(File dest) 将当前File对象所指向的路径修改为指定File所指向的路径
    4. File 类的其他获取功能
        * String[] list(); 以字符串的形式返回当前路径下所有的文件和文件夹的名称
        * File[] listFile 以File对象的形式返回当前路径下的所有文件和文件夹名称
        * Static File[] listRoots() 获取计算机中的所有盘符
       