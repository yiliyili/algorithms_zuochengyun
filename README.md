# algorithms_zuochengyun
左程云的算法与数据结构代码



在运行左程云算法时，有包名如package chapter_8_arrayandmatrix;  如果编译的时候不加上-d .则生成的class文件无论如何都不能运行,只能去掉源码中的包名才行

C:\Users\xx\algorithms_zuochengyun\BookCode\src\chapter_8_arrayandmatrix>**javac -d . Problem_11_LongestSumSubArrayLength.java**

C:\Users\xx\algorithms_zuochengyun\BookCode\src\chapter_8_arrayandmatrix>**java chapter_8_arrayandmatrix.Problem_11_LongestSumSubArrayLength**

-3 3 3 -2 0 -3 2 4 -3 -4 5 0 -4 3 2 1 -5 2 -3 2

0

另一种运行方式是源码中注释掉第一行package chapter_8_arrayandmatrix;然后

C:\Users\xx\\algorithms_zuochengyun\BookCode\src\chapter_8_arrayandmatrix>**javac Problem_11_LongestSumSubArrayLength.java**

C:\Users\xx\algorithms_zuochengyun\BookCode\src\chapter_8_arrayandmatrix>**java Problem_11_LongestSumSubArrayLength**

1 0 -2 -5 5 3 4 2 1 0 -5 1 -5 -5 3 4 3 -4 2 1

16