# redis-work
redis演示项目：
（1）springBoot集成redis；
（2）编写redis工具类；
（3）使用redis支持数据类型实现简单的业务场景。

一、常用数据类型及应用场景

	Redis支持5种数据结构存储，而且分别为这5种类型数据提供了独特的数据存储、操作方式。redis支持的所有数据结构的缓存实现均可以使用简单的Key-Value
(String)结构来完成，但在实际实现上会出现一些序列化/反序列化开销过大、内存浪费等问题，如果使用redis自身提供的复杂数据结构的存储、操作方式则不用担心
出现这些问题，而且实现方式也会显得很优雅。

数据类型	
（1）String	
value就是一个字符串，string 类型是 Redis 中最基本的数据类型，最常用的数据类型	常规key-value缓存应用。
（2）Hash	  
内部实现为一个HashMap，可以缓存对象属性名及属性值，redis提供直接更改指定对象属性值的方法。
（3）List	  
内部实现为一个双向链表，可以支持反向查找和遍历（在方便数据操作的同时也带来了部分额外的内存开销），redis提供leftpush和rightpush的方法来插入元素。
（4）Set	    
内部实现为一个value永远为null的HashMap，实际就是通过计算hash的方式来快速排重的提供自动去重功能。
（5）Sorted sort	
在自动去重功能上提供额外参数按优先级score排序功能。内部使用HashMap和跳跃表(SkipList)来保证数据的存储和有序，HashMap里放的是成员到
score的映射，而跳跃表里存放的是所有的成员，排序依据是HashMap里存的score,使用跳跃表的结构可以获得比较高的查找效率，并且在实现上比较简单。


