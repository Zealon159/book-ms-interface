-- MySQL dump 10.13  Distrib 5.7.18, for macos10.12 (x86_64)
--
-- Host: localhost    Database: book-ms
-- ------------------------------------------------------
-- Server version	5.7.18

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` int(11) NOT NULL COMMENT '作者',
  `dic_category` int(11) NOT NULL COMMENT '分类',
  `dic_channel` tinyint(11) NOT NULL COMMENT '频道ID:0全部,1男生,2女生,3出版物',
  `dic_serial_status` tinyint(4) NOT NULL COMMENT '连载状态',
  `online_status` bit(1) NOT NULL COMMENT '状态：0下架，1上架',
  `book_id` varchar(20) NOT NULL COMMENT '图书ID',
  `book_name` varchar(100) NOT NULL COMMENT '图书名称',
  `book_score` tinyint(4) NOT NULL COMMENT '图书评分',
  `key_word` varchar(150) DEFAULT NULL COMMENT '关键词',
  `img_url` varchar(200) DEFAULT NULL COMMENT '封面',
  `author_name` varchar(50) NOT NULL COMMENT '作者名称',
  `introduction` text COMMENT '简介',
  `isbn` varchar(30) DEFAULT NULL COMMENT 'ISBN',
  `word_count` int(11) DEFAULT NULL COMMENT '字数',
  `creater` varchar(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `updater` varchar(20) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_bookid` (`book_id`),
  KEY `key_author` (`author_id`) USING BTREE,
  KEY `key_book_name` (`book_name`) USING BTREE,
  KEY `key_dic_02` (`dic_category`,`dic_channel`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='图书表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (4,29,3,1,1,'','10004411','剑斩天下',8,'剑斩天下 ; 虚尘 ;','attachment/2020-03-17/d19baa9ca2b54b7ca1b3e89ca651896e.jpg','张阳小白','一秋江海倒入壶，三千星河聚为图。驾鹤几顾摘星阁，携美乘舟泛五湖。','',1000,'admin','2020-03-17 15:54:06','2020-03-17 15:54:06','admin'),(5,6,3,1,3,'','10009145','至尊武魂',9,'','attachment/2020-03-17/dff0db4e673a414494dd0821c8bc9dde.jpg','小白','少年本是天骄，却遭受未婚妻夺舍武魂；落魄废物，却觉醒双武魂，踏上崛起之路；疯狂修炼，粉碎一切敌人，从小小的郡城，一步步到诸天万界！','',1094,'admin','2020-03-17 15:55:53','2020-03-17 15:55:53','admin'),(6,8,2,2,1,'','10043456','狐色妖娆：女扮男装来修仙',8,' 穿越 ; 修仙 ;','attachment/2020-03-17/fd83cb54740f43b18d676c7926f57465.jpg','苏陌','不过是试玩一个修仙类的游戏，启动游戏这一瞬间我竟然穿越到上古时期。更坑爹的事是我突然莫名成为九尾狐族的九尾天狐，喂啊，我还能不能回去？等等，不对不对，相似的场景，相似的人设。等等等等，我难道是被卷入那个未来世界所拍的十里桃花？','',415,'admin','2020-03-17 15:59:00','2020-03-17 15:59:00','admin'),(7,11,8,1,3,'','88043024','穿越火影之宇智波音',7,'穿越','attachment/2020-03-17/b904bdfe5cf74c3982d116c2adab0d17.jpg','鸣人','无论你信不信，你与这本书的缘分在一千年前就已经注定……\n否则你不会点开……\n放弃它就是放弃你自己的故事……','',621,'admin','2020-03-17 16:00:01','2020-03-17 16:00:01','admin'),(8,13,8,2,2,'','60013441','魔帝，你家妖妃拽破天',8,'穿越','attachment/2020-03-17/3915f30be97d454f8aaf8943a3e27bc4.jpg','小非同学','现代佣兵女皇一朝穿越，成为毫无修为，肌肤漆黑干瘪豆芽菜的小废柴？那是你们无知，姐本是绝世天才好么。当丑陋容颜退去，换上那张雌雄莫辨逆天绝色之姿时，顿时令天下男女为止疯狂。修炼进阶，顺便虐渣渣，生活好不惬意，但某个大胆女人脑子一抽，调戏了某个正在沐浴的绝世美男，从此被纠缠，掐掉朵朵桃花。','',555,'admin','2020-03-17 16:01:31','2020-03-17 16:01:31','admin'),(9,8,1,2,1,'','52156116','妙医娇妻：总裁老公宠上天',9,'','attachment/2020-03-17/f2d974e1c532431e9bde47c9ca035bc3.jpg','苏陌','这年头，都流行穿古，偏偏她反其道而行，不仅魂穿越现代，还顺带抓了个高智能的“球？”，而且原主还被结婚？老公还是个双腿残废不能人道的家伙。算了，有本神医在，啥病都能痊愈。原本以为小日子就是修炼加谈恋爱，可谁想到被某人宠上了天，不仅得了个绝世好男人，还发现这家伙还不是一般“人”某个高科技的飞船上，银球','',782,'admin','2020-03-17 16:02:25','2020-03-17 16:02:25','admin'),(10,25,1,1,3,'','10053255','都市全能高手',8,'','attachment/2020-03-17/1ba972a09bcd4bd1afd33c3987b8846c.jpg','野小子','受尽别人白眼的季枫，在人生的低谷之际，得到了未来的科技产品，拥有了神奇的能力，从此他的人生变得不再平凡！透视功能，赌石无往不利。未来科技，让季枫成就商业帝国，训练系统，成就非凡身手。季枫的人生，变得无限精彩！','',902,'admin','2020-03-17 16:04:43','2020-03-17 16:04:43','admin'),(11,6,8,1,3,'','1000941','我在万界送外卖',9,'穿越; 青春','attachment/2020-03-17/4def07aa46444a87912ee10b7ed9f91b.jpg','小白','叶晨八岁那年，算命老道说：你十八岁那年将黄袍加身，天天山珍海味为伴！\n我信你个鬼你这糟老头子！外卖员的黄颜色工作服也是黄袍加身？\n结果叶晨果真成了黄袍加身鱼肉为伴的外卖员，不过…他的外卖能够联通万界！动漫，武侠，玄幻，电影，神话世界中都有他送外卖的身影，客户回馈给叶晨的报酬也都是溜到不行！','',1215,'admin','2020-03-20 16:06:10','2020-03-17 16:06:10','admin'),(12,8,6,2,3,'','5145666','综穿之白莲花逆袭系统',9,'系统流 ; 逆袭 ;','attachment/2020-03-18/76b3c9217d264d19848b8225858ae1fc.jpg','苏陌','女主无意中抽奖领取了白莲花逆袭系统并与之绑定，开始了逆袭计划，穿越于各个世界，完成任务换取积分点，来完成自己的夙愿，使时光倒流，改变自己的人生。千金女贼。活色生香，终极少女。古剑奇谭，原来是美男啊，花样男子……带你穿越各个影视世界感受不一样的逆袭。','',314,'admin','2020-03-18 13:36:18','2020-03-18 13:36:18','admin'),(13,24,3,1,3,'','5551111','我的动漫女友们',10,'二次元; 校园;','attachment/2020-03-18/f09ce9a87b414215ab48a04f26134209.jpg','魏无羡','不幸被店招砸死穿越到乱世三国时期……，一步步修炼成为绝世高手，遇到仙人左慈，成为修真者，奇遇连连之后却被人围攻致死，却利用灵体修炼数百年重新练成肉身，出关后一路飞结果飞到了一片高楼大厦……\n伪造身份成为sh市的普通大学生，刚想过普通的生活，却遇到最初让我穿越并成就不死之身的神族','',895,'admin','2020-03-20 14:15:05','2020-03-18 14:15:05','admin'),(14,24,2,1,3,'','555111778','九婴邪仙',8,'','attachment/2020-03-18/96194f14c0e44ff49ba503fa1e43e062.jpg','魏无羡','故老相传，超脱于修真界之外，有一个浩瀚的仙界，百族林立，有莫大的机遇，有无尽的天材地宝，更有无尽的修炼福地。龙颜，身怀九个元婴的怪才，一步步踏上修仙之路，他该如何求仙证道，斩尽九天十地，成就无上仙路。','',1224,'admin','2020-03-18 14:16:17','2020-03-18 14:16:17','admin'),(15,24,8,1,3,'','72100766','极品王爷',8,'','attachment/2020-03-18/f3a625564eb440af9ccde9cbd3aad70b.jpg','魏无羡','意外穿越到古代，附身落魄地主的儿子，因地制宜，运用前世的经营策略开始圈地。直至最后成为全国最富有的土皇帝，这皇帝老子不当也罢，就当个逍遥王爷岂不更快活！','',661,'admin','2020-03-18 14:18:14','2020-03-18 14:18:14','admin'),(16,26,1,1,3,'','125626344','校草大人万万岁',7,'青梅竹马 ; 宠文 ; 校草 ;','attachment/2020-03-18/fd86b5bedd9841479f5b18066d3f567d.jpg','圣诞不快乐','踏入北家的第一天，席小童总算明白了——北奕宸，人前是一个听话懂事的小少爷，但是背后却是天天折磨自己的大恶魔！\n六岁七岁八岁一直到现在，这个恶魔还在欺负自己啊！\n“北奕宸，你闹够没有啊，欺负我那么多年，你还不腻啊！”席小童翻着白眼说道。\n坐在她对面的美男子，俊美无双的脸上露出一抹浅浅的笑容，站起','',315,'admin','2020-03-18 18:36:15','2020-03-18 18:36:15','admin'),(17,19,1,2,3,'','323221','许你一笑倾城',8,'唯美; 叙事;','attachment/2020-03-18/220c9298f6474db088f54356bf9a21fc.jpg','水门','绿树成荫的校道，别具风格的教学楼，一张张充满活力的笑脸把C大的冬日渲染得温暖动人！\nC大是M市的高校，素以学风良好人才辈出著称。可是最近不知怎么回事，一个连载漫画竟然席卷了这所优等生学院，上至校长下至老师都为此头疼不已。\n放午学期间，熙熙攘攘的食堂，密密麻麻的人头像是蚂蚁一样，宣示着此时的热闹。','',124,'admin','2020-03-18 18:41:27','2020-03-18 18:41:27','admin'),(18,12,8,2,3,'','44353533','穿越之奇葩江湖',8,'穿越; 历史;','attachment/2020-03-18/6236a48ae05a4e329d0bb59a9d580dee.jpg','鼬','童星出身的凌无忧在自己十八岁生日会场上被从天而降的车轮胎砸晕倒霉的挂了，穿越到一个刷新三观的异空世界，轻工内力宝剑还有会化人形的狐狸！ 凌无忧内心崩溃淡定的接受，但是泪奔质问：谁说江湖大侠都是浩然正气拔刀相助两肋插刀的？楚千歌就不是，他就是一个无耻流氓脸皮厚的大混蛋。 沉鱼落雁闭月羞花倾','',551,'admin','2020-03-18 18:43:24','2020-03-18 18:43:24','admin'),(19,11,7,1,3,'','515264','女权世界的男剑仙',9,' 二次元 ;','attachment/2020-03-20/3d281694fd23451abf4b69d580a197d8.jpg','鸣人','楚青穿越到一个女权至上的世界，他发现一切都不一样了！\n在这里，女追男才是主流，女的赚钱养家，男的负责貌美如花！\n男人要讲究夫德，而女人要有房有车才能娶到男人，甚至女人被男人养，也会被说是吃软饭？\n尼玛哟，甚至还有一群女人整天想着怎么去泡仔！身为“校花”的楚青走在大街上，那个回头率高哦！\n可是，凭什么','',788,'admin','2020-03-20 14:06:59','2020-03-20 14:06:59','admin'),(20,14,7,1,3,'','33','海贼王之光暗果实',8,'时光易老 ; 海贼王之光暗果实 ;','attachment/2020-03-20/4b6ccfdcaf3e434ca430a7d28b2111ab.jpg','强大的猪','一个生活在社会低层的可怜少年，意外中实现了自己的海贼梦，来到了海贼王的世界\n决心走向世界最强的男人，成为海贼王\n拥有海军六式，霸气诀窍，百万人中只有一个人才拥有的，帝王资质的霸王色霸气，一颗毁灭性果实的食用者到底这个少年是否可以让这个世界颠覆呢，那就一起来欣赏下他战海军，斗武海，挑四皇，达颠覆','',3453,'admin','2020-03-20 23:17:15','2020-03-20 23:17:15','admin');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_author`
--

DROP TABLE IF EXISTS `book_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '作者名称',
  `introduction` varchar(5000) NOT NULL COMMENT '作者简介',
  `head_img_url` varchar(200) DEFAULT NULL COMMENT '头像附件URL',
  `creater` varchar(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `updater` varchar(20) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_author`
--

LOCK TABLES `book_author` WRITE;
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
INSERT INTO `book_author` VALUES (4,'罗门','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-16/114727e6f2574c7ebaa9c630d313b302.jpeg','admin','2020-03-16 10:47:19','2020-03-17 15:31:21','admin'),(6,'娶个精灵做老婆','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-16/7b6d975a9f30421fafae19b178132365.jpeg','admin','2020-03-16 10:54:31','2020-03-18 14:11:20','admin'),(7,'豆娘','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/9f9e7f295faf43cd8c831f62cd226e1a.jpg','admin','2020-03-16 13:07:24','2020-03-17 15:30:31','admin'),(8,'苏陌','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/6051ed002ba148c1a39aabce847b364b.jpg','admin','2020-03-17 15:32:42','2020-03-17 15:32:42','admin'),(9,'巫门老九','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/df235defd1ba43f88c54477b3e14b8c2.jpg','admin','2020-03-17 15:33:25','2020-03-17 15:33:25','admin'),(10,'润田','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/ea772f20ae2a48c3b4d777b287533dbf.jpg','admin','2020-03-17 15:33:47','2020-03-17 15:33:47','admin'),(11,'鸣人','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/cea3453d3f3f4ef9bebf71bf7ab242ac.jpg','admin','2020-03-17 15:33:59','2020-03-17 15:33:59','admin'),(12,'鼬','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-18/ba906dc24c674dca99077bd1f4834cac.jpg','admin','2020-03-17 15:34:17','2020-03-18 22:46:03','admin'),(13,'小非同学','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/f8188e11785d401ead14a66312416e69.jpg','admin','2020-03-17 15:34:44','2020-03-17 15:34:44','admin'),(14,'强大的猪','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/12ef93f33e9d478698bb83fb019b3f77.jpg','admin','2020-03-17 15:35:05','2020-03-17 15:35:05','admin'),(15,'一梦江山','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/b8a4faf3fac74c7888a681a4ebacf600.jpg','admin','2020-03-17 15:35:33','2020-03-17 15:35:33','admin'),(16,'我爱吃蓝莓','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/04e95a1de9a74da3be6aa40d5ad9588e.jpg','admin','2020-03-17 15:35:51','2020-03-17 15:35:51','admin'),(17,'卡卡西','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/b0f9f06d1072436fade11e5cce3c6936.jpg','admin','2020-03-17 15:36:01','2020-03-17 15:36:01','admin'),(18,'草帽','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/06e8096acb854c58870197331a149664.jpg','admin','2020-03-17 15:36:12','2020-03-17 15:36:12','admin'),(19,'水门','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/1b711622fdfc48919efaa0ed374852b0.jpg','admin','2020-03-17 15:36:22','2020-03-17 15:36:22','admin'),(20,'王子','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/4c97bfbbf00c4d678159f67d7998b067.jpg','admin','2020-03-17 15:36:34','2020-03-17 15:36:34','admin'),(21,'索隆','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/3cf542ceb654437d83d31dca37f2c606.jpg','admin','2020-03-17 15:36:51','2020-03-17 15:36:51','admin'),(22,'L','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/e5daa07d42a74281ad38590bec117bd4.jpeg','admin','2020-03-17 15:37:00','2020-03-17 15:37:00','admin'),(23,'洛天依','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-18/a16f80099eae4a2e99e992566d48fa88.jpg','admin','2020-03-17 15:37:12','2020-03-18 22:57:49','admin'),(24,'魏无羡','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/8234496cb7944d289912058c5bc8a889.jpg','admin','2020-03-17 15:37:25','2020-03-17 15:37:25','admin'),(25,'野小子','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/0e62049a17ef4681a164528e28ed4fc1.jpg','admin','2020-03-17 15:37:47','2020-03-17 15:37:47','admin'),(26,'圣诞不快乐','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/2c641660474c4c06a8fe0e38fe7a74c4.jpg','admin','2020-03-17 15:38:04','2020-03-17 15:38:04','admin'),(27,'黑桃King','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/8b3f72b0a2c74f07a54191787233f189.jpg','admin','2020-03-17 15:38:24','2020-03-17 15:38:24','admin'),(28,'鸟鸭','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/11e7e8c9cc004caf81834126c8219416.jpeg','admin','2020-03-17 15:49:23','2020-03-17 15:49:23','admin'),(29,'张阳小白','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/cceee5ec0be44b06ab6b7f53f8c1f7cf.jpg','admin','2020-03-17 15:49:48','2020-03-17 15:49:48','admin'),(30,'一叶知秋','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/030ca661286947b19e38bda30baada3e.jpeg','admin','2020-03-17 15:50:14','2020-03-17 15:50:14','admin'),(31,'三手烟','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/b9a042ef21274c0fafdb803ebd540372.jpg','admin','2020-03-17 15:50:26','2020-03-17 15:50:26','admin'),(32,'邪灵一把刀','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/e4ba59e409a940288b585a9fa7ebb3bd.jpeg','admin','2020-03-17 15:50:42','2020-03-17 15:50:42','admin'),(33,'丹妮莉丝','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/12249ad8f6c948639330fb19739815d4.jpg','admin','2020-03-17 15:50:51','2020-03-17 15:50:51','admin'),(34,'蘑菇','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/0c655358c70e45b0a6c2141f9fbe9a14.jpg','admin','2020-03-17 15:50:59','2020-03-17 15:50:59','admin'),(35,'女王','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/6b726e10a61b4d15ad46be29e40483cd.jpg','admin','2020-03-17 15:51:18','2020-03-17 16:06:40','admin'),(36,'三眼乌鸦','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/8aaa43828f964e57b0dbec904c3fd8c8.jpg','admin','2020-03-17 15:51:32','2020-03-17 15:51:32','admin'),(37,'你不懂我','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/d857a697f1bb4f16a7c9ec4f08bae05e.jpg','admin','2020-03-17 15:51:43','2020-03-17 15:51:43','admin'),(38,'不懂温柔','该作者很低调，没有留下简介，去看看ta的作品吧','attachment/2020-03-17/77ac136247864fc49b76d658a09c474b.jpg','admin','2020-03-17 15:51:54','2020-03-17 15:51:54','admin');
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_chapter`
--

DROP TABLE IF EXISTS `book_chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_chapter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL COMMENT '所属图书',
  `name` varchar(100) NOT NULL COMMENT '章节名称',
  `content` text NOT NULL COMMENT '章节内容',
  `lock_status` bit(1) NOT NULL COMMENT '锁章状态(0:无,1:锁章)',
  `sort_number` int(11) DEFAULT NULL COMMENT '排序',
  `creater` varchar(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `updater` varchar(20) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`),
  KEY `index_book_id` (`book_id`),
  KEY `index_sort_number` (`sort_number`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_chapter`
--

LOCK TABLES `book_chapter` WRITE;
/*!40000 ALTER TABLE `book_chapter` DISABLE KEYS */;
INSERT INTO `book_chapter` VALUES (2,15,'3131','1','\0',1,'admin','2020-03-18 17:11:37','2020-03-18 17:35:59','admin'),(3,18,'第一章 阎王有点二','秦淮五月，繁花似锦，一切都显得热情洋溢，就像最近的江湖一样热闹，然而江湖为什么这么热闹呢？还用问，当然是要举行武林盟主选举了。\n这不，还没到大会期间，江南城就聚集了来自四面八方的英雄好汉，非常的热闹。\n一个古香古色人满为患的酒楼，来自四面八方的人正在高谈阔论，场面十分热闹，犹如现代的街市一般。\n一个满脸胡腮的壮汉笑道：“无影宫宫主应该到了吧。”\n另一个大汉笑道：“他来了也是去剑灵山庄。”直逼真相，真是非常非常的聪明！\n周围的人闻言，立即欢快的加入讨论，你一言我一语，非常有市场大妈的气质，丝毫不给江湖的各路英雄丢脸。\n无影宫是近两年崛起的大派，宫主楚千歌不仅年少有为，武功出神入化，还长得人神共愤，家财万贯，典型的高富帅，非常非常的拉仇恨！还有一件特别拉仇恨的事，就是年初剑灵山庄庄主凌云嵇把千金凌无忧许配给了他，要知道，剑灵山庄庄主最疼爱的就是这个女儿，并且凌无忧还是燕国第一美女，琴棋书画，无一不通。\n两人一公布亲事，江湖上可谓是掀起了从所未有的波浪，真是一件特别特别值得好好讨论一番的大事。\n光线阴暗，氛围诡异的石头屋，一位身着粉色连衣裙的女孩幽幽醒来，看一眼类似鬼屋的环境，皱眉的起身，满心疑惑的打量起周围的环境。\n另外一个躺在地上的女孩也幽幽醒来，单纯的眼睛里透露着迷茫，有些艰难的起身打量四周的环境。\n两人很自然的看到了对方，凭借着若有似无的光线，纷纷被对方的穿着打扮与样貌吓到了，两人样貌一模一样，只不过一个看起来俏皮活泼，一个看起来温婉可人。\n穿着粉色连衣裙的凌无忧艰难的咽口水，声音脆脆的问：“你谁啊？怎么跟我长的一模一样？不对，你像两年前的我，但是差不多。”\n梳着丱发穿着粉色绮云裙的凌无忧茫然的点头，显然不知道要如何回答这个问题。\n忽然台上一亮，一个身穿黑衣的人坐在中间，此人眉飞入鬓，五官硬朗，样貌极佳，此时正襟危坐，犹如一尊佛像。\n两个女孩被吓了一跳，但是看到那人样貌如此出众，心里的恐惧又少了一点。\n打扮得像是古代人一样的女孩内心带着点恐惧的抓紧衣领，弱弱的问：“请问公子是何人？”自己不是在家里准备迎接楚千歌吗？怎么会莫名其妙的到了这个地方？\n穿着粉色连衣裙的女孩看着台上的人，大眼睛骨碌碌的茫然转动，参加生日宴会，跟粉丝互动，想着想着，凌无忧忽然想起自己好像在切蛋糕的时候被什么东西砸到了，但是为什么会在这里，满心的疑惑。\n坐在椅子上的人面色青黑，说话声像是从远处传来的一样毫无生气，“凌无忧，你俩寿命已到，这是阎罗殿，现在本官给你们判刑。”\n“什么？”穿着粉丝连衣裙的凌无忧睁大眼睛看看台上的人，一脸不可置信的看着他，“你说什么？”\n另一个女孩闻言脸色苍白，阎罗殿，惊恐万状的察看周围环境，四周黑漆漆的，不远处像是有凄惨的叫声，忍不住浑身颤抖起来，脑子一片混乱。\n穿着粉色连衣裙的女孩看一眼周围的环境，再想想自己前面的事，本来恐惧的心一点点放松下来，因为她把这一切归结于自己正在做梦！\n帅哥阎王看着生死簿，手里拿着生死判笔，正准备下笔时判官忽然浑身一颤，“阎王。”\n阎王抬头看向台下的人，判官看一眼不知身处何方的人，凑到阎王耳边低低的说了几句。\n阎王闻言脸色大变，看着台下站在中间两个清丽的小身影，低声道：“情况属实？”\n判官点头，唯唯诺诺的说：“属实。”\n帅哥阎王狠狠地瞪一眼他，咽口水，看向台下一直没有说话的凌无忧，清清嗓子，声音平淡无奇的开口：“凌无忧。”\n“我去，我居然死了，有没有搞错，老娘明明什么都没有做好不好？你们是不是搞错了？”帅哥阎王刚出声穿着粉色连衣裙的凌无忧就火箭炮似的的开口说话，目光如炬的盯着台上的人，反正是做梦，她也不怕了。\n旁边看起来温婉一点的凌无忧默默的睁大眼睛，钦佩的看着旁边的人，居然这么厉害，敢顶撞阎王爷。\n帅哥阎王听到凌无忧的话被噎了一下，表情有些不自在，非常冷静咳一声，“咳，现在本官核查，你俩死于非命，牛头马面会带你们回去的。”\n穿着粉色连衣裙的凌无忧闻言睁大眼睛，不可置信的说：“哇靠，你们还真搞错了，要不要这么奇葩，你真的是阎王吗？确定不是演戏？”\n帅哥阎王被凌无忧说得脸色一阵红一阵白，最后恼羞成怒的开口：“好了，现在送你们回去，来人，带她们回去还魂。”\n旁边一直不说话的凌无忧一脸懵逼的看着事情的发展，感觉自己理解能力好像不够用了。\n两个穿着乱七八糟的破布，脸上像是涂了唱戏一样的妆容的‘人’上前，示意凌无忧跟他们走。\n阎王与判官小声的说着什么，容貌俏丽的凌无忧看向台上的人，笑眯眯的说：“帅哥，长得不赖嘛，就是脑子有点二。”说着笑呵呵的走了。\n帅哥阎王脸色通红，一口气噎在喉咙里不上不下，大吼：“你才二，你全家都二。”\n判官在一旁忍笑。\n两个凌无忧跟着小将慢悠悠的走着，性格开朗的那个看向旁边的人，问：“你也叫凌无忧？你是哪里人啊？”\n旁边温婉的女孩闻言，柔柔弱弱的点头轻声道：“嗯，小女子是剑灵山庄庄主的女儿，姑娘呢？”\n旁边的凌无忧眨眨眼睛，脑袋转得飞快，居然是不同时代的，豪迈的摆摆手，说：“我就是一个很多年后的人，说不定我是你的后代呢，哈哈。”看着不远处的悬崖，毫不在意的说，“嘿嘿，梦差不多要醒了，很高兴认识你。”\n“啊？”另一个凌无忧明显没有明白她的话。\n牛头马面开口：“好了，现在你们各归各位，来。”\n“嗖”他刚说完话穿着粉色连衣裙的凌无忧就毫不犹豫的跳下去，速度快得堪比火箭。\n牛头马面互相看一眼，然后脸色大变，一人飞速跟着向下跳，另一个把旁边的凌无忧推下去，然后也跟着跳下去。','\0',1,'admin','2020-03-18 22:47:37','2020-03-18 22:47:37','admin'),(4,18,'第二章 阴差阳错的重生','热闹的酒楼，众人还在高谈阔论，突然不知谁大喊一声：“无影宫宫主来了。”\n话一出，酒楼瞬间万人空巷，全部跑出门口，有的在楼上探出身子，丝毫感觉不到自己正在冒着生命危险的进行围观。\n瞬时只见一匹白马飞驰而过，后面非常拉风的跟着十几个黑色衣服的影卫，典型现代社会的黑社会大帮。\n一位脑残粉马上眼冒星星的喊：“楚宫主真是风流倜傥！”\n旁边的人马上接口：“玉树临风！”\n“气宇轩昂！”\n“一表人才！”\n“举世无双！”\n“英俊神武！”\n……\n整个酒楼里充斥着浓浓的赞美的语句，非常非常的像发了烧的脑残粉！\n而街道两旁的百姓则一脸茫然，完全不知道发生了什么事，不过看到飞驰而过的一群黑衣人，还是好激动。\n此刻剑灵山庄正在鸡飞狗跳的准备迎接仪式，要知道，庄主夫人可是十分满意这位女婿的，所以灯红结彩、开办宴席是必须的！\n庄主夫人看着不远处的儿子，笑眯眯的喊道：“无月，去叫你妹妹过来，千歌也快到了。”\n凌无月头疼的看着他的娘亲，不是说舍不得把妹妹嫁出去？那现在急着把妹妹叫出来是怎么回事？\n“夫人，夫人，”一个扎两根小辫子的女孩急匆匆的跑过来，“不好了，不好了，小姐出门摔倒昏迷了。”\n“什么！”庄主夫人眼睛睁大，晃了下身子，觉得头晕目眩，还好不远处的凌无月飞快的移到她身边，扶住了才没有摔下去。\n庄主夫人急忙抓住儿子的手臂，语无伦次的喊：“快带我去看看小忧。”\n凌无月抱着自家娘亲，脚尖轻起，凌空飞步，不一会儿就到了凌无忧的房间，而此时里面已挤满了人。\n庄主夫人看着床上闭着眼睛的人，眼泪瞬间出来了，飞扑上去，撕心裂肺的喊：“我的儿啊，你怎么了？怎么会突然晕了过去呢？”\n一旁的凌庄主见此，上前安慰道：“不用担心，小忧只是昏迷了，一会儿就醒了。”\n凌夫人闻言，哭得更厉害了，“小忧啊，你可不要离娘亲而去啊。”\n一屋子的人满头黑线，只是昏迷了而已，不要哭喊的这么撕心裂肺，会让人以为她不是昏迷了而是命不久矣。\n凌云嵇眼神像猎鹰一般的射向众人旁边惶恐不安的小丫头，声音冷酷且严肃，“快说，小姐怎么回事？”\n那小丫头身体一颤，马上跪下去，抽抽噎噎的说：“庄主饶命，本来小姐正准备去前堂，出门时踩到裙角，就摔了。”\n在场的人闻言，瞬间沉默了，表情无比的复杂。\n凌无忧昏昏沉沉的睁开眼，看着粉色的床顶，脑袋一片空白，转头看向床边的人，疑惑，谁呀？再看看，古香古色的房子，一屋子不认识的人，脑子有点儿死机。\n一个天青色素衣青年看到凌无忧，惊喜的喊道：“爹娘，小忧醒了。”\n一屋子的人一窝蜂跑到床边，目光灼灼的盯着她。\n凌无忧艰难的咽咽口水，都谁啊，看着我干嘛，有些头疼的伸手摸向脑袋，秀眉轻蹙，感觉脑子晕乎乎的。\n凌夫人看到凌无忧醒来，马上笑颜如花的看着她，眼睛还是红红的，“小忧，你终于醒来了。”\n凌无忧看着她，不认识啊，小心翼翼的问：“请问，你谁啊？”为什么一个认识的人都没有，皱眉想自己为什么会在这里，可是一想她脑袋就阵阵的疼，无力作罢。\n全场静得异常，满屋子的人张大嘴巴看着她，像是被雷劈了一样。\n凌夫人反应过来，又扑到她身上，嗷嗷大哭，“哎呦，我的儿啊，你怎么了？”\n一位白衣少年看着她，皱眉，小心翼翼的问：“小忧，你怎么了？”\n凌无忧撑起身子，皱眉，“芸姐呢？”芸姐是她的经纪人，按理说她会随时跟着她的，此时却不见人，着实有些惊讶。\n一屋子的人面面相觑，芸姐是谁？不认识啊！凌庄主气势如虹的问：“庄里可有芸姐这个人？”\n在场的人纷纷安静，随后一个个说从来没有听说过，李姐秋姐夏姐都有，就是没有芸姐。\n凌无忧睁大眼睛，表情略呆，犹是二十一世纪新新人类的她，脑子也有点儿转不过来，明明是在生日宴会上，为什么突然到了这里，还一个人都不认识。\n凌庄主看着一脸茫然的女儿，压住心惊，颤声的说：“小忧，记不记得我是谁？”\n满屋子的人紧张的看着凌无忧，眼神无比炙热，恨不得把她看得穿个洞。\n凌无忧看着他们，摇摇头。\n凌庄主深吸一口气，对旁边的大夫狂喊：“快去看一下小姐怎么了？”\n凌无忧被他吼得一颤一颤的，咽咽口水，一颗心扑通扑通的跳，大叔您的肺活量真好！\n几个大夫战战兢兢地围着凌无忧把脉，额头一直冒汗，要知道，五月的江南还是很凉快的！\n凌云嵇还在怒气冲冲，脸色黑得像一块炭，像是下一秒就要燃气熊熊烈火，而凌夫人哭的泪流满面，妆都花了，并且非常非常的，吵！\n凌无忧看着眼前的状况，昏沉的脑袋逐渐清醒，迅速分析情况，心里的震惊越来越大，忍住惊讶虚弱的的问：“你们是谁？”弱柳扶风般娇弱的声音令在场的人无不动容，再看看小鹿般惊怕的眼神，真是我见犹怜。\n凌云嵇一掌拍向旁边的桌子，桌子瞬间碎成渣渣，怒吼：“到底怎么了？”\n凌无忧看着那个桌子，艰难的咽口水，这到底是什么人啊！\n一位大夫小心翼翼的开口：“小姐应该是失忆了，身体没什么情况，好好休养就可以了。”\n在愣了一分钟后，凌无忧终于正确清楚的知道，自己，穿越了！\n庄主怒不可遏的把大夫赶出去，然后一群人围着凌无忧，眼里满满的都是关心。\n庄主夫人伤心又担心得看着凌无忧，哭道：“小忧，我是娘亲，还记得我吗？”\n凌无忧看到这位中年美妇伤心哭泣的模样，心里有些内疚，可是看看旁边的大叔，她还是充分发挥童星实力，茫然的摇摇头，“不记得。”\n话一出，庄主夫人哭的天昏地暗肝肠寸断！\n旁边的青年闻言，立马追问：“小忧，记得我吗？二哥啊！”\n“我是大哥。”\n……\n凌无忧被他们说得脑仁直疼，忍不住开口：“那个，我头疼。”\n此话一出，房间瞬间安静下来。\n凌云嵇摆摆手，语气满满的疲倦，“小忧刚醒，让她好好休息一下，菱花，照顾好小姐。”\n一群人出去，人满为患的房间顿时恢复安静。\n一直隐藏在床头的牛头看着这个局面，有些心虚的抹一把额头上的汗，瞬间消失。\n奈何桥头，牛头马面同时回来，两人互相看一眼，分别从对方眼里看出“天知地知你知我知”的意思来，一言不发的往阎罗殿走去。\n阴深诡异的阎罗殿，阎王坐在椅子上，漫不经心的问：“事情如何了？”\n牛头抱拳，低头恭敬的回答：“已消除她们的记忆让她们两个还魂。”\n帅哥阎王闻言点点头，挥手让他们退下。\n牛头马面胆战心惊的退下，觉得这份差事真是要鬼命，当初阎王让他们带两个凌无忧去还魂，谁知道其中一个还不等他们反应就直接跳了下去，魂已归位，他们两个也就将错就错，消除了她们在地府的记忆让她们这样活着了。\n两个人互相看一眼，有些心虚的想，应该不会出什么问题的，唉！','\0',2,'admin','2020-03-18 22:58:33','2020-03-18 22:58:33','admin'),(5,18,'第三章 未婚夫！','安静的房间，凌无忧看着旁边抽抽噎噎的女孩，问：“你叫什么名字？”\n女孩一听，哇的一声哭出来，“小姐，你真的忘了菱花了。”\n凌无忧眉头一皱，零花，什么东东！\n菱花看到凌无忧的神情，伤心的说：“‘菱花落复含，桑女罢新蚕’，小姐您说我本来出身不好，然后帮我取的名字啊。”\n凌无忧囧囧有神，这么有诗意的名字我可取不出来，无辜的小声道：“我忘了。”想了想，又问，“我怎么了？”\n菱花又开始哭哭啼啼的说：“小姐，您摔倒了。”\n凌无忧：“……”\n凌无忧问：“怎么摔的？”\n菱花哭道：“您出门时踩到裙角，头磕到地就晕了。”\n凌无忧闻言，内心无比纠结，踩裙角，我有这么笨吗？翻个身，无力的说：“出去吧，我要休息。”脑子一片浆糊，还是早点儿理清楚比较好。\n菱花担忧的看了眼凌无忧，犹犹豫豫一步一回头的出去了。\n房间安静下来，凌无忧开始整理自己的思路，生日宴会、表演、切蛋糕，然后好像被什么东西砸晕，中间一段空白，醒来就穿越了。\n凌无忧揉揉有些胀痛的脑袋，觉得有些晕，逼迫自己放空大脑，又昏昏沉沉的睡过去了。\n策马奔腾一路狂飙的楚千歌一到剑灵山庄就感觉到里面的氛围异常，抓住一个家丁就问，“发生什么事了？”\n楚千歌虽然还不是剑灵山庄的女婿，但是他来过几次，又是全国上下公认的高富帅，画像是一张接着一张，剑灵山庄的众多下人还是认识他的，此时家丁看到他，顿时激动不已，一边紧张激动，一边伤心欲绝的说：“楚宫主，小姐摔倒了，现在还昏迷不醒。”','\0',3,'admin','2020-03-18 22:58:53','2020-03-18 22:58:53','admin'),(6,18,'第四章 十分淑女','凌无忧眨眨眼，内心十分激动，帅哥啊！努力让自己十分淑女，轻声细语的问：“请问，你是谁？”\n帅哥开口了，“小忧真的把为夫忘了。”\n声音如心中所想般的性感动人，但是内容，凌无忧睁大眼睛，为夫，卧槽卧槽，快告诉她这不是真的！小心翼翼艰难的问：“为夫？”\n楚千歌走近凌无忧，一把搂住，深情的哭诉相思之情，“小忧，我好想你。”\n凌无忧风中凌乱，穿越就算了，为夫是神马东东？这不科学！于是内心凌乱，柔弱万分的晕了过去，天地可鉴，她是被吓晕了！\n穿越可以接受，但是整一个夫君出来就不好了，想她二十一世纪的时候可是连初牵初吻初拥都还在的人，现在你跟我说有了老公，果断要晕过去！\n楚千歌紧紧的抱住凌无忧，眉头紧锁，犹豫要不要叫人，最后还是给她吃一颗药丸。\n凌无忧悠悠醒来，看着面前放大的俊脸，差点儿又晕过去，有气无力的推开楚千歌，试图说道理，“我失忆了，不记得你是谁。”\n楚千歌伤心的指控，“我不远千里来找你，你却如此无情。”\n凌无忧：“……”心中悲愤的呐喊，“我不是啊！”\n楚千歌深情的看着凌无忧，伸手抚上她的脸颊，眼神无比温柔。\n凌无忧身体僵硬，内心一万头草泥马奔腾，脸上神色紧张，可是又不能怎么样，这是丈夫，难道还不给碰！真是十分的悲催！\n楚千歌看着闭上眼，表情僵硬的凌无忧，眼神一敛，手继续动作，慢慢向下。\n凌无忧一把推开楚千歌，紧张抓紧衣口，“我不舒服。”\n楚千歌看到凌无忧的动作，心里忍笑，表情明显的受伤，却还是一副翩翩公子的说：“我尊重小忧。”\n凌无忧内心对他好感噌噌往上增。\n凌无风进门，看了眼床上的人，说：“千歌，客房已准备好了，先去休息吧，小忧也休息一下。”\n楚千歌看着凌无忧，没有动作。\n凌无忧看着房内的那个身形颀长，眉目俊朗的锦衣青年，眼神略迷茫。\n凌无风叹口气，“小忧，我是大哥，凌无风。”\n凌无忧：“……”\n凌无忧：“大哥好。”看着自己床上的人，忽然感觉有点儿不对劲，不是丈夫吗！怎么不是一起睡？口随心想的问出来，“我们不是一起睡的？”\n话一出，凌无风目瞪口呆的看着自己的妹妹，以前不是见到都躲起来，怎样现在一出口就如此劲爆！\n楚千歌闻言，立马兴奋的说：“小忧，你要跟我一起睡？”\n凌无忧不知道该怎么回答，心中却想，难道这个世界的夫妻不同房，如果这样，那真是好到无法言语！\n凌无风看到自己妹妹不说话，心怕她继续说出什么话，急忙说：“千歌，你们还没有成亲，这关乎小忧的清白。”\n“什么？”凌无忧愤怒的看着楚千歌，绝美的脸庞因生气更显得生动，“没成亲你说什么丈夫。”害的她刚才还对他感到愧疚。\n楚千歌立马小媳妇状的看着凌无忧，委屈的说：“我们已经订婚了。”\n“订婚还可以退婚，别说订婚，结婚了都还可以离婚。”凌无忧异常愤怒，把二十一世纪人的思想完美诠释。\n凌无风皱眉的看着自家妹妹，从未见过她说过如此率性的话。\n楚千歌闻言，难过的指责凌无忧，“难道你想始乱终弃？”\n凌无忧：“……”少侠您的词用得真好，没错，就是，我现在想快刀斩乱麻，才不要神马未婚夫。\n楚千歌看着凌无忧不言而喻的表情，脸一黑，语气冰冷，嘴里蹦出几个字，“想都别想。”说完快步出了凌无忧的房间。\n凌无风无奈的看了眼凌无忧，跟着出去了，然后菱花进门服侍。','\0',4,'admin','2020-03-18 22:59:21','2020-03-18 22:59:21','admin'),(7,18,'第五章 幼稚的哥哥们','前面帮凌无忧进行诊断的大夫出了山庄后立马小声讨论剑灵山庄的小姐摔倒失忆，并且楚宫主已到了山庄，一到山庄就进了凌小姐的房间。\n要相信市民的力量，仅仅一个下午，偌大个江南城的人都知道了凌无忧摔倒失忆，楚宫主进房，然后……两天，大半个江湖的人都知道了剑灵山庄小姐摔倒失忆，楚宫主进房，传播的速度堪比网络！\n各种小本本唰唰唰的传出来，版本多到让人眼花缭乱，但丝毫不影响大家对这件事正确的认识，楚宫主进了凌小姐的房间，至于干什么，简直不能多想，我们都是非常纯洁的！\n楚千歌站在一酒楼，听着影卫汇报各种版本，神色淡然。\n影卫汇报完，看着楚千歌，小心翼翼的说：“宫主，右护法说他明天到。”\n果然，楚千歌闻言，脸色漆黑，沉声道：“他到了原地待命，继续盯着，有任何动静向我汇报，明月，跟我去山庄。”\n楚千歌身后一青衣女子闻言，点头，“好的，宫主。”\n外面传成什么样子凌无忧当然不知道，因为这两天除了睡就是吃，连房门都不能多出，一出去就被赶回房里，真是郁闷到发霉！\n不过还好，两天时间把情况了解了个大概。\n剑灵山庄是江湖上数一数二的大派，她是山庄的小姐，上头有四个哥哥，每个都是江湖上排得上名号的人，大哥是文武全才，二哥擅剑术，三哥善医，现在在无涯谷，四哥善轻工，她还有个未婚夫，无影宫宫主楚千歌。\n这天，凌无忧坐在小院里听着菱花叽里呱啦的说话，听到她说楚千歌，心里有点儿纳闷，好像那天过后就没见过他了，于是随意问道：“他人呢？”\n话一落，门口就走进来一人，话语非常的欠揍，“小忧想念为夫了？”\n凌无忧一听，差点一口鲜血喷出来，想你妹啊想，心里这样想，脸上却是一副娇羞模样，低眉颔首，没有说话，因为她从菱花嘴里得知，凌无忧是一个娇羞温柔，才貌双全的女子，所以她不能表现得太过两极。\n菱花见此，非常狗腿的笑道：“宫主好，小姐刚才还在说宫主呢。”\n凌无忧瞪了眼菱花，不说话没人把你当哑巴！\n菱花委屈的撇撇嘴。\n楚千歌好笑的看着凌无忧，温柔的问道：“没事了吧？”\n凌无忧点头，“好多了。”\n楚千歌一笑，“那为夫就放心了。”\n凌无忧无奈，纠正，“我们还没有成亲。”所以不要一直为夫为夫的喊，听着我心累。\n楚千歌一听，惊喜的说：“小忧想成亲了？虽然你还没有及笄，但是我们可以先办婚礼。”\n凌无忧一惊，急忙道：“没有没有，我不想。”才来两天，谁想成亲啊，再说了，这未婚夫也不是我的啊。\n楚千歌闻言，心里有些纳闷，神情很受伤的看着凌无忧，落寞的说：“我听小忧的。”\n凌无忧囧囧的看着楚千歌，少侠，您这个表情很容易让人误会我在欺负你啊！\n凌夫人一进门就看到女儿女婿正在小院子里相谈甚欢，于是心里非常的开心，笑容满面的说：“小忧千歌，聊完了吗？要吃饭了。”\n凌无忧急忙站起身，惊喜的问：“我可以去吃饭了？”这两天都在喝补汤，小米粥，非常的想念饭啊！\n凌夫人看着她急切的小脸，好笑的说：“可以啊，这两天是为了你的身体着想才让你喝补汤的。”\n凌无忧闻言，开心的笑了起来，心里欢呼：“太好了！”飞快的走出小院。\n凌夫人看着女儿匆忙的背影，感叹：“小忧长大了。”\n凌无忧闻言，走得更快了，很害怕她娘会在后面加一句，可以嫁人了啊！\n楚千歌看到凌无忧匆忙的脚步，嘴角一扬，貌似不一样了啊。\n凌无忧出了小院，四处看看，曲院风荷，四面八方都是路，不得已停住脚步，不认识路，因为来了两天，还没出过小院。\n楚千歌与凌夫人出门就看到凌无忧站在小院前不动。\n凌夫人欣慰的说：“小忧在等娘亲吗？”\n凌无忧笑笑，从容淡定的说：“是啊。”的确是，因为不认识路。\n凌夫人很满意，牵着她的手走去大厅，楚千歌在后面跟着。\n凌云嵇与凌无风等兄弟都在大厅，看到凌无忧，都站起身热情的说：“小忧，来吃饭，快来大（二四）哥这里坐。”\n兄弟三人互相看一眼，又轰轰烈烈的吵了起来，没错，就是又，因为就算凌无忧在卧室呆了两天，她还是一天几次看到她哥哥们为了她吵架。\n庄主看着三个儿子，非常霸气的怒吼：“都给我安静下来。”\n三兄弟马上安静下来，一个个低头不语，就像在班主任面前认错的小学生一样。\n凌无忧赞赏的看了她爹一眼，还是老的靠谱。\n凌夫人跟楚千歌进门，看到丈夫与儿子们的神色，果断的无视，拉着凌无忧跟楚千歌坐一块儿。\n凌无风：“……”狠狠地瞪一眼楚千歌，凭什么一来就可以跟自己的妹妹坐，真是非常的不爽！\n楚千歌淡定的看了眼凌无风兄弟，然后贴心的为凌无忧舀一碗汤，体贴入微的说：“小忧，先喝口汤，润润喉。”\n凌无忧满脸娇羞的看着楚千歌，微微一笑，轻齿柔语：“谢谢！”内心十分的崩溃，弄得如此恩爱的模样是要闹哪样？\n凌夫人看到楚千歌与凌无忧恩爱的样子，眼睛都笑眯了，乐呵呵的说：“千歌，看到你跟小忧如此恩爱，娘亲很是欣慰，要不你们办了婚礼再去蓬莱仙岛？”\n话一出，在场的人都安静下来。\n楚千歌似笑非笑的看一眼凌无忧，神色淡然。\n凌无忧一口汤喷出来，瞪着她娘，娇羞的说：“娘，你说什么呢？”丫的，她可没忘她这里的年龄还没到十六岁，想想她前世十六岁，还扎着小辫子上高中呢！就算是童星，她也是个爱好学习的好学生。\n楚千歌看着凌无忧，既深情，又伤心的说：“小忧，难道你不愿意？你放心，我会等到你心甘情愿与我成亲的那天。”\n凌夫人闻言，赞许的看着楚千歌，神情激动。\n凌无忧闻言，窘窘有神，小声说：“我不记得你了。”内心苦逼的呐喊：要结婚也不是跟我啊，所以我非常的不愿意！大侠，您退婚吧！\n楚千歌毫不在意的开口：“小忧，我相信有天你会记得我的。”\n凌无忧：“……”\n凌云嵇看到女儿有些无奈的神色，急忙帮忙打圆场道：“好了，先吃饭，有什么事以后再说。”\n凌无忧闻言，有点儿诧异的看了眼她爹，怎么感觉她爹对这场婚事并不是很满意，心想以后有机会一定要探探口风。\n楚千歌闻言没有说话，若无其事的继续吃饭，好像庄主的话对他并没有任何影响。','\0',5,'admin','2020-03-18 22:59:44','2020-03-18 22:59:44','admin');
/*!40000 ALTER TABLE `book_chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_dictionary`
--

DROP TABLE IF EXISTS `data_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dic_type` varchar(30) NOT NULL COMMENT '字典类型',
  `dic_type_name` varchar(30) NOT NULL COMMENT '类型名称',
  `code` int(11) NOT NULL COMMENT '字典编码',
  `name` varchar(50) NOT NULL COMMENT '字典名称',
  `sort_number` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_dic_type` (`dic_type`,`code`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='数据字典';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_dictionary`
--

LOCK TABLES `data_dictionary` WRITE;
/*!40000 ALTER TABLE `data_dictionary` DISABLE KEYS */;
INSERT INTO `data_dictionary` VALUES (1,'category','书籍分类',1,'都市小说',1),(2,'category','书籍分类',2,'东方玄幻',2),(3,'category','书籍分类',3,'武侠仙侠',3),(4,'category','书籍分类',4,'悬疑惊悚',4),(5,'category','书籍分类',5,'西方玄幻',5),(6,'category','书籍分类',6,'网游竞技',6),(7,'category','书籍分类',7,'科幻未来',7),(8,'category','书籍分类',8,'历史穿越',8),(9,'channel','所属频道',1,'男生',1),(10,'channel','所属频道',2,'女生',2),(11,'channel','所属频道',3,'出版',3),(14,'serial_status','连载状态',1,'连载',1),(15,'serial_status','连载状态',2,'暂更',2),(16,'serial_status','连载状态',3,'完结',3);
/*!40000 ALTER TABLE `data_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_dept`
--

DROP TABLE IF EXISTS `org_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  `sort_number` int(11) NOT NULL COMMENT '排序',
  `creater` varchar(20) NOT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updater` varchar(20) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_dept`
--

LOCK TABLES `org_dept` WRITE;
/*!40000 ALTER TABLE `org_dept` DISABLE KEYS */;
INSERT INTO `org_dept` VALUES (1,'开发组',1,'admin','2020-01-17 16:00:00','2020-03-13 02:09:44','admin'),(2,'测试组',1,'admin','2020-01-17 16:00:00','2020-03-13 02:09:44','admin'),(3,'运营组',3,'admin','2020-01-17 16:00:00','2020-01-17 16:00:00','admin');
/*!40000 ALTER TABLE `org_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_permission`
--

DROP TABLE IF EXISTS `org_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL COMMENT '父级ID',
  `name` varchar(50) NOT NULL COMMENT '菜单名称',
  `type` varchar(10) DEFAULT NULL COMMENT '菜单类型(catalog:目录，menu:菜单，button:按钮)',
  `resource_url` varchar(100) DEFAULT NULL COMMENT '资源地址',
  `permission` varchar(50) NOT NULL COMMENT '权限名称',
  `icon` varchar(50) DEFAULT NULL COMMENT 'Icon',
  `sort_number` int(11) DEFAULT '99' COMMENT '排序',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `updater` varchar(50) DEFAULT NULL COMMENT '更新者',
  `has_children` bit(1) DEFAULT NULL COMMENT '是否有子节点',
  `page_path` varchar(100) DEFAULT NULL COMMENT '页面路径',
  PRIMARY KEY (`id`),
  KEY `key01` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='系统权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_permission`
--

LOCK TABLES `org_permission` WRITE;
/*!40000 ALTER TABLE `org_permission` DISABLE KEYS */;
INSERT INTO `org_permission` VALUES (1,0,'图书管理','menu','','','el-icon-s-management',1,'admin','2020-02-09 07:35:15','2020-02-09 07:35:15','admin','',NULL),(2,0,'后台管理','menu','','','fa fa-gear',2,'admin','2020-02-09 07:35:52','2020-02-09 07:35:52','admin','',NULL),(8,2,'部门管理','menu','/org/dept-list','','',1,'admin','2020-02-09 14:03:42','2020-02-09 14:03:42','admin','','org/dept-list'),(10,2,'用户管理','menu','/org/user-list','','',2,'admin','2020-03-03 02:49:17','2020-03-03 02:49:17','admin','','org/user-list'),(11,2,'角色管理','menu','/org/role-list','1','',3,'admin','2020-03-03 02:51:14','2020-03-03 02:51:14','admin','','org/role-list'),(12,2,'菜单权限','menu','/org/permission-list','','',4,'admin','2020-03-03 02:51:40','2020-03-03 02:51:40','admin','','org/permission-list'),(18,1,'图书','menu','/book/list','','',1,'','2020-03-04 07:50:43','2020-03-04 07:50:43','','','book/book-list'),(19,10,'新增用户','menu','/org/user-add','','',1,'admin','2020-03-10 01:41:36','2020-03-10 01:41:36','admin','\0','org/user-add'),(20,10,'编辑用户','menu','/org/user-edit/:id','','',2,'admin','2020-03-10 01:42:20','2020-03-10 01:42:20','admin','\0','org/user-edit'),(21,11,'新增角色','menu','/org/role-add','','',1,'admin','2020-03-10 01:43:36','2020-03-10 01:43:36','admin','\0','org/role-add'),(22,11,'编辑角色','menu','/org/role-edit/:id','','',2,'admin','2020-03-10 01:44:22','2020-03-10 01:44:22','admin','\0','org/role-edit'),(23,12,'新增菜单','menu','/org/permission-add','','',1,'admin','2020-03-10 01:45:01','2020-03-10 01:45:01','admin','\0','org/permission-add'),(24,12,'编辑菜单','menu','/org/permission-edit/:id','','',2,'admin','2020-03-10 01:45:35','2020-03-10 01:45:35','admin','\0','org/permission-edit'),(25,8,'新增','menu','/org/dept-add','','',1,'admin','2020-03-13 03:10:13','2020-03-13 03:10:13','admin','\0','org/dept-add'),(26,8,'编辑','menu','/org/dept-edit/:id','','',2,'admin','2020-03-13 03:10:34','2020-03-13 03:10:34','admin','\0','org/dept-edit'),(28,1,'字典配置','menu','/dictionary/list','','',4,'admin','2020-03-13 10:22:29','2020-03-13 10:22:29','admin','','dictionary/list'),(29,28,'新增字典','menu','/dictionary/add','','',1,'admin','2020-03-13 10:23:42','2020-03-13 10:23:42','admin','\0','dictionary/add'),(30,28,'编辑字典','menu','/dictionary/edit/:id','','',2,'admin','2020-03-13 10:24:17','2020-03-13 10:24:17','admin','\0','dictionary/edit'),(31,1,'作者管理','menu','/book/author-list','','',3,'admin','2020-03-14 15:16:53','2020-03-14 15:16:53','admin','','book/author-list'),(32,31,'新增作者','menu','/book/author-add','','',1,'admin','2020-03-14 15:17:28','2020-03-14 15:17:28','admin','\0','book/author-add'),(33,31,'编辑作者','menu','/book/author-edit/:id','','',2,'admin','2020-03-16 04:46:28','2020-03-16 04:46:28','admin','\0','book/author-edit'),(34,18,'新增','menu','/book/book-add','','',1,'admin','2020-03-16 09:56:43','2020-03-16 09:56:43','admin','\0','book/book-add'),(35,18,'编辑','menu','/book/book-edit/:id','','',2,'admin','2020-03-17 08:29:29','2020-03-17 08:29:29','admin','\0','book/book-edit'),(36,41,'作者信息','menu','/book/author-details/:id','','',-2,'admin','2020-03-18 06:41:58','2020-03-18 06:41:58','admin','\0','book/author-details'),(37,18,'章节列表','menu','/book/chapter-list/:bookId','','',4,'admin','2020-03-18 08:46:51','2020-03-18 08:46:51','admin','\0','book/chapter-list'),(38,18,'删除','button','','','',3,'admin','2020-03-18 08:47:15','2020-03-18 08:47:15','admin','\0',''),(39,18,'新增章节','menu','/book/chapter-add/:bookId','','',5,'admin','2020-03-18 08:49:11','2020-03-18 08:49:11','admin','\0','book/chapter-add'),(40,18,'编辑章节','menu','/book/chapter-edit/:id','','',6,'admin','2020-03-18 08:49:57','2020-03-18 08:49:57','admin','\0','book/chapter-edit'),(41,0,'阅读','menu','','','',-1,'admin','2020-03-19 01:08:46','2020-03-19 01:08:46','admin','',''),(42,41,'图书信息','menu','/book/book-details/:id','','',-3,'admin','2020-03-19 01:10:09','2020-03-19 01:10:09','admin','\0','book/book-details'),(43,41,'阅读内容','menu','/book/book-read/:id','','',-1,'admin','2020-03-19 01:10:49','2020-03-19 01:10:49','admin','\0','book/book-read'),(44,1,'小福利','menu','/welfare/girls','','',99,'admin','2020-03-20 06:17:36','2020-03-20 06:17:36','admin','\0','welfare/girls');
/*!40000 ALTER TABLE `org_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_role`
--

DROP TABLE IF EXISTS `org_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `sort_number` int(11) DEFAULT NULL COMMENT '排序',
  `creater` varchar(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `updater` varchar(20) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_role`
--

LOCK TABLES `org_role` WRITE;
/*!40000 ALTER TABLE `org_role` DISABLE KEYS */;
INSERT INTO `org_role` VALUES (1,'管理员','12',1,'admin','2020-03-20 14:19:00','2020-03-20 14:19:00','admin'),(2,'内容编辑','',2,'admin','2020-03-18 16:45:27','2020-03-18 16:45:27','admin'),(4,'测试人员','',2,'admin','2020-03-18 16:45:13','2020-03-18 16:45:13','admin');
/*!40000 ALTER TABLE `org_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_role_permission`
--

DROP TABLE IF EXISTS `org_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL COMMENT '权限ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  KEY `key01` (`role_id`,`permission_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=337 DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_role_permission`
--

LOCK TABLES `org_role_permission` WRITE;
/*!40000 ALTER TABLE `org_role_permission` DISABLE KEYS */;
INSERT INTO `org_role_permission` VALUES (310,1,1),(324,2,1),(325,8,1),(328,10,1),(331,11,1),(334,12,1),(311,18,1),(329,19,1),(330,20,1),(332,21,1),(333,22,1),(335,23,1),(336,24,1),(326,25,1),(327,26,1),(321,28,1),(322,29,1),(323,30,1),(318,31,1),(319,32,1),(320,33,1),(312,34,1),(313,35,1),(308,36,1),(315,37,1),(314,38,1),(316,39,1),(317,40,1),(305,41,1),(307,42,1),(309,43,1),(306,44,1),(244,1,2),(245,18,2),(242,1,4),(243,18,4);
/*!40000 ALTER TABLE `org_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_user`
--

DROP TABLE IF EXISTS `org_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_user` (
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `dept_id` int(11) NOT NULL COMMENT '所属部门',
  `user_pwd` varchar(100) NOT NULL COMMENT '密码',
  `user_name` varchar(20) NOT NULL COMMENT '中文名',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `sort_number` int(11) NOT NULL COMMENT '排序',
  `head_img_url` varchar(200) DEFAULT NULL,
  `creater` varchar(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `updater` varchar(20) NOT NULL COMMENT '更新者',
  `freeze_status` bit(1) DEFAULT b'0' COMMENT '冻结状态',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_user`
--

LOCK TABLES `org_user` WRITE;
/*!40000 ALTER TABLE `org_user` DISABLE KEYS */;
INSERT INTO `org_user` VALUES ('111',3,'0f9d4c30d7b3d4e991ca5bace91b49a0','111','1',111,NULL,'admin','2020-03-16 15:54:21','2020-03-16 15:54:30','admin','\0'),('aaa',3,'a20aca20d3d9f00efe2c4d7f3347182b','AAA1','22',22,NULL,'admin','2020-02-05 16:57:00','2020-03-16 15:54:09','admin','\0'),('admin',1,'9ab616b1ef023972cab83781e97565e5','不懂温柔','13800138000',99,'attachment/2020-03-16/ad50149fd04f4a32a0cf8030a4a3e03a.jpeg','admin','0020-01-18 00:00:00','2020-03-05 13:30:29','','\0'),('ddd',1,'16309a81428d814dd7accaebed55b9a1','DDD','13800138002',11,NULL,'admin','0020-01-18 00:00:00','2020-02-06 10:36:26','admin',''),('iwanvi',2,'0d42ff6387b5d3587bb04df3f4a91d36','中文万维','12131',1,NULL,'','2020-02-04 16:12:28','2020-03-09 09:14:12','admin','\0'),('mingming',2,'785d85bc8b4557902528e531630fed82','明明','',4,NULL,'iwanvi','2020-02-06 10:28:24','2020-02-06 10:28:24','iwanvi','\0');
/*!40000 ALTER TABLE `org_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_user_role`
--

DROP TABLE IF EXISTS `org_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(30) NOT NULL,
  `role_id` int(11) NOT NULL COMMENT '角色',
  PRIMARY KEY (`id`),
  KEY `org_user_role_userId_IDX` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_user_role`
--

LOCK TABLES `org_user_role` WRITE;
/*!40000 ALTER TABLE `org_user_role` DISABLE KEYS */;
INSERT INTO `org_user_role` VALUES (20,'mingming',4),(21,'admin',2),(22,'admin',1),(23,'iwanvi',1),(25,'aaa',1);
/*!40000 ALTER TABLE `org_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_attachment`
--

DROP TABLE IF EXISTS `sys_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_attachment` (
  `id` char(32) NOT NULL,
  `document_id` int(11) NOT NULL COMMENT '所属表实例ID',
  `table_code` varchar(200) NOT NULL COMMENT '所属表',
  `table_field` varchar(200) NOT NULL COMMENT '所属字段(前端定义)',
  `name` varchar(200) NOT NULL COMMENT '附件名称',
  `file_path` varchar(200) DEFAULT NULL COMMENT '相对路径',
  `ext_name` varchar(50) DEFAULT NULL COMMENT '扩展名',
  `file_size` varchar(50) DEFAULT NULL COMMENT '附件大小',
  `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `key01` (`document_id`,`table_code`,`table_field`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通用附件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_attachment`
--

LOCK TABLES `sys_attachment` WRITE;
/*!40000 ALTER TABLE `sys_attachment` DISABLE KEYS */;
INSERT INTO `sys_attachment` VALUES ('030ca661286947b19e38bda30baada3e',30,'author','head','3.jpeg','attachment/2020-03-17/','.jpeg','19.1 KB','admin','2020-03-17 07:49:56'),('04e95a1de9a74da3be6aa40d5ad9588e',16,'author','head','1-7.jpg','attachment/2020-03-17/','.jpg','26.8 KB','admin','2020-03-17 07:35:41'),('06e8096acb854c58870197331a149664',18,'author','head','5-4.jpg','attachment/2020-03-17/','.jpg','23.2 KB','admin','2020-03-17 07:36:06'),('0ab1e7d9c9044a2db853e96b6a4cfbd2',3,'author','head','165314-.jpeg','attachment/2020-03-16/','.jpeg','35.5 KB','admin','2020-03-16 02:46:48'),('0c655358c70e45b0a6c2141f9fbe9a14',34,'author','head','6.jpg','attachment/2020-03-17/','.jpg','7.2 KB','admin','2020-03-17 07:50:56'),('0e62049a17ef4681a164528e28ed4fc1',25,'author','head','5-199.jpg','attachment/2020-03-17/','.jpg','16.5 KB','admin','2020-03-17 07:37:29'),('114727e6f2574c7ebaa9c630d313b302',4,'author','head','165314-.jpeg','attachment/2020-03-16/','.jpeg','35.5 KB','admin','2020-03-16 05:07:15'),('11e7e8c9cc004caf81834126c8219416',28,'author','head','1.jpeg','attachment/2020-03-17/','.jpeg','19.8 KB','admin','2020-03-17 07:49:13'),('1200d15063134620982ed8be4f24db89',0,'author','head','165314-.jpeg','attachment/2020-03-16/','.jpeg','35.5 KB','admin','2020-03-16 01:50:53'),('12249ad8f6c948639330fb19739815d4',33,'author','head','7.jpg','attachment/2020-03-17/','.jpg','30.9 KB','admin','2020-03-17 07:50:47'),('12ef93f33e9d478698bb83fb019b3f77',14,'author','head','2-1.jpg','attachment/2020-03-17/','.jpg','118.7 KB','admin','2020-03-17 07:34:56'),('1b711622fdfc48919efaa0ed374852b0',19,'author','head','5-5.jpg','attachment/2020-03-17/','.jpg','45.1 KB','admin','2020-03-17 07:36:18'),('1ba972a09bcd4bd1afd33c3987b8846c',10,'book','cover','都市全能高手.jpg','attachment/2020-03-17/','.jpg','16.8 KB','admin','2020-03-17 08:04:32'),('1c5df09ac5574040b8f1c1e2462579a3',0,'book','cover','165314.jpg','attachment/2020-03-17/','.jpg','36.9 KB','admin','2020-03-17 03:52:45'),('220c9298f6474db088f54356bf9a21fc',17,'book','cover','许你一笑倾城.jpg','attachment/2020-03-18/','.jpg','13.1 KB','admin','2020-03-18 10:40:56'),('24787bfd31da40b2ae75db3d627ee0ec',23,'author','head','103.jpg','attachment/2020-03-18/','.jpg','30 KB','admin','2020-03-18 14:52:53'),('25a09ed103214aeca5ad338d37273436',0,'author','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 02:26:36'),('2c641660474c4c06a8fe0e38fe7a74c4',26,'author','head','5.jpg','attachment/2020-03-17/','.jpg','45 KB','admin','2020-03-17 07:37:56'),('2fb9a81132de49fab9b7aedef3d06633',0,'author','head','165314-.jpeg','attachment/2020-03-16/','.jpeg','35.5 KB','admin','2020-03-16 02:07:33'),('3915f30be97d454f8aaf8943a3e27bc4',8,'book','cover','魔帝，你家妖妃拽破天.jpg','attachment/2020-03-17/','.jpg','29.7 KB','admin','2020-03-17 08:01:09'),('3cf542ceb654437d83d31dca37f2c606',21,'author','head','5-9.jpg','attachment/2020-03-17/','.jpg','13.6 KB','admin','2020-03-17 07:36:41'),('3d281694fd23451abf4b69d580a197d8',19,'book','cover','女权世界的男剑仙.jpg','attachment/2020-03-20/','.jpg','20.6 KB','admin','2020-03-20 06:06:30'),('48a267a73081413a80253a3f9dc42194',0,'author','head','timg.jpeg','attachment/2020-03-16/','.jpeg','22.5 KB','admin','2020-03-16 04:56:05'),('4b6ccfdcaf3e434ca430a7d28b2111ab',20,'book','cover','海贼王之光暗果实.jpg','attachment/2020-03-20/','.jpg','19.2 KB','admin','2020-03-20 15:21:08'),('4c97bfbbf00c4d678159f67d7998b067',20,'author','head','5-7.jpg','attachment/2020-03-17/','.jpg','23.2 KB','admin','2020-03-17 07:36:28'),('4def07aa46444a87912ee10b7ed9f91b',11,'book','cover','我在万界送外卖.jpg','attachment/2020-03-17/','.jpg','21 KB','admin','2020-03-17 08:05:56'),('58c741b3012a403297f6088d5944f2a4',0,'author','head','123.jpg','attachment/2020-03-16/','.jpg','25.3 KB','admin','2020-03-16 04:49:20'),('6051ed002ba148c1a39aabce847b364b',8,'author','head','1-6.jpg','attachment/2020-03-17/','.jpg','33.3 KB','admin','2020-03-17 07:31:35'),('6236a48ae05a4e329d0bb59a9d580dee',18,'book','cover','穿越之奇葩江湖.jpg','attachment/2020-03-18/','.jpg','23.1 KB','admin','2020-03-18 10:42:33'),('62af4ca937ee4e1ab17aaccf734cc365',0,'author','head','165314.jpg','attachment/2020-03-16/','.jpg','36.9 KB','admin','2020-03-16 04:48:56'),('65eabfb48ca14739b43e96908b1e6b2b',4,'author','head','timg.jpeg','attachment/2020-03-16/','.jpeg','22.5 KB','admin','2020-03-16 02:47:18'),('678edc5b133b4475985b900cdd28bc22',0,'user','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 07:46:14'),('69a99c352709402a9dfd7886fd3488b7',0,'author','head','165314-.jpeg','attachment/2020-03-16/','.jpeg','35.5 KB','admin','2020-03-16 02:40:36'),('6b726e10a61b4d15ad46be29e40483cd',35,'author','head','9.jpg','attachment/2020-03-17/','.jpg','39.5 KB','admin','2020-03-17 07:51:04'),('6e5a8d4b18654ec0b02fcf0c8d25ab4d',0,'author','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 01:29:45'),('704a5854daad4f4f9579ed5a250745a7',0,'author','head','9-1.jpg','attachment/2020-03-17/','.jpg','128.9 KB','admin','2020-03-17 07:38:11'),('746b66b83cc6449385bd1392e2b62bba',0,'author','head','timg.jpeg','attachment/2020-03-16/','.jpeg','22.5 KB','admin','2020-03-16 04:57:49'),('76146dbf155d48a495814f77f332ff2c',23,'author','head','5-15.jpg','attachment/2020-03-17/','.jpg','47 KB','admin','2020-03-17 07:37:06'),('76b3c9217d264d19848b8225858ae1fc',12,'book','cover','综穿之白莲花逆袭系统.jpg','attachment/2020-03-18/','.jpg','24.2 KB','admin','2020-03-18 05:36:06'),('77ac136247864fc49b76d658a09c474b',38,'author','head','11.jpg','attachment/2020-03-17/','.jpg','19.2 KB','admin','2020-03-17 07:51:46'),('7b6d975a9f30421fafae19b178132365',6,'author','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 02:54:25'),('8234496cb7944d289912058c5bc8a889',24,'author','head','5-17.jpg','attachment/2020-03-17/','.jpg','32.5 KB','admin','2020-03-17 07:37:20'),('88ee90f2e1ae4e63a8e955d02782c8a0',2,'author','head','165314-.jpeg','attachment/2020-03-16/','.jpeg','35.5 KB','admin','2020-03-16 02:41:13'),('8a8627fcdfc84e0fa4f7f892ac23d45b',0,'user','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 07:43:14'),('8aaa43828f964e57b0dbec904c3fd8c8',36,'author','head','8.jpg','attachment/2020-03-17/','.jpg','41 KB','admin','2020-03-17 07:51:23'),('8b3f72b0a2c74f07a54191787233f189',27,'author','head','1-2.jpg','attachment/2020-03-17/','.jpg','289.2 KB','admin','2020-03-17 07:38:18'),('8f58d37c9aed475f9ad6dad5c23c2c8e',0,'book','cover','165314.jpg','attachment/2020-03-17/','.jpg','36.9 KB','admin','2020-03-17 03:51:22'),('9251cf2cb5f54a6d9445d0076fe424f2',0,'author','head','165314-.jpeg','attachment/2020-03-16/','.jpeg','35.5 KB','admin','2020-03-16 02:26:17'),('96194f14c0e44ff49ba503fa1e43e062',14,'book','cover','九婴邪仙.jpg','attachment/2020-03-18/','.jpg','21.7 KB','admin','2020-03-18 06:16:03'),('975e3ff8c7d54ab6aea83473efdefc11',0,'book','cover','3d281694fd23451abf4b69d580a197d8.jpg','attachment/2020-03-20/','.jpg','20.6 KB','admin','2020-03-20 14:59:17'),('9f353c0a939043bbbeba6f84d85347f2',2,'book','cover','165314.jpg','attachment/2020-03-17/','.jpg','36.9 KB','admin','2020-03-17 05:42:31'),('9f9e7f295faf43cd8c831f62cd226e1a',7,'author','head','1-1.jpg','attachment/2020-03-17/','.jpg','53.7 KB','admin','2020-03-17 07:29:12'),('a0964ead4b9549db8be8a121c738394c',0,'user','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 07:44:52'),('a0a5cb5c8d5a44a1bab09b31f3c19463',5,'author','head','timg.jpeg','attachment/2020-03-16/','.jpeg','22.5 KB','admin','2020-03-16 05:07:02'),('a16f80099eae4a2e99e992566d48fa88',23,'author','head','103.jpg','attachment/2020-03-18/','.jpg','31.7 KB','admin','2020-03-18 14:57:48'),('a4f94258f240407a93aa51b8c19579b8',0,'user','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 07:46:57'),('a58bb1422723417280e7df1cc4a566f6',7,'author','head','165314.jpg','attachment/2020-03-16/','.jpg','36.9 KB','admin','2020-03-16 05:07:23'),('a7a5adc84309488b8c1480a5ffd10424',1,'book','cover','165314.jpg','attachment/2020-03-17/','.jpg','36.9 KB','admin','2020-03-17 05:41:07'),('ad50149fd04f4a32a0cf8030a4a3e03a',92668751,'user','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 07:51:40'),('b0f9f06d1072436fade11e5cce3c6936',17,'author','head','5-3.jpg','attachment/2020-03-17/','.jpg','11.5 KB','admin','2020-03-17 07:35:58'),('b8a4faf3fac74c7888a681a4ebacf600',15,'author','head','3-5.jpg','attachment/2020-03-17/','.jpg','50.5 KB','admin','2020-03-17 07:35:16'),('b904bdfe5cf74c3982d116c2adab0d17',7,'book','cover','穿越火影之宇智波音.jpg','attachment/2020-03-17/','.jpg','23.1 KB','admin','2020-03-17 07:59:52'),('b9a042ef21274c0fafdb803ebd540372',31,'author','head','2.jpg','attachment/2020-03-17/','.jpg','33.1 KB','admin','2020-03-17 07:50:19'),('ba906dc24c674dca99077bd1f4834cac',12,'author','head','1-2.jpg','attachment/2020-03-18/','.jpg','37.8 KB','admin','2020-03-18 14:46:02'),('c03aaf6c13d4415286dcb58a05cd28ec',12,'author','head','5-2.jpeg','attachment/2020-03-17/','.jpeg','30.7 KB','admin','2020-03-17 07:34:05'),('cceee5ec0be44b06ab6b7f53f8c1f7cf',29,'author','head','4.jpg','attachment/2020-03-17/','.jpg','43.1 KB','admin','2020-03-17 07:49:33'),('cea3453d3f3f4ef9bebf71bf7ab242ac',11,'author','head','5-1.jpg','attachment/2020-03-17/','.jpg','23.6 KB','admin','2020-03-17 07:33:54'),('d19baa9ca2b54b7ca1b3e89ca651896e',4,'book','cover','剑斩天下.jpg','attachment/2020-03-17/','.jpg','21.8 KB','admin','2020-03-17 07:53:44'),('d40c815c7e5f4ce1ac6e17e403044047',12,'author','head','1-2.jpg','attachment/2020-03-18/','.jpg','24.1 KB','admin','2020-03-18 14:41:01'),('d46ae1a19f4e4d6f8a3e041fb344075f',0,'user','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 07:44:23'),('d857a697f1bb4f16a7c9ec4f08bae05e',37,'author','head','10.jpg','attachment/2020-03-17/','.jpg','14.2 KB','admin','2020-03-17 07:51:36'),('d9cbd21d826b4b268eeb0304eef00b81',1,'author','head','709a7701.jpeg','attachment/2020-03-16/','.jpeg','4.9 KB','admin','2020-03-16 02:30:45'),('dd2306aaa27c4ad18d1e8877b3f5c60e',0,'book','cover','3d281694fd23451abf4b69d580a197d8.jpg','attachment/2020-03-20/','.jpg','20.6 KB','admin','2020-03-20 14:56:25'),('df235defd1ba43f88c54477b3e14b8c2',9,'author','head','1.jpg','attachment/2020-03-17/','.jpg','46.5 KB','admin','2020-03-17 07:33:14'),('dff0db4e673a414494dd0821c8bc9dde',5,'book','cover','至尊武魂.jpg','attachment/2020-03-17/','.jpg','19.7 KB','admin','2020-03-17 07:55:45'),('e4ba59e409a940288b585a9fa7ebb3bd',32,'author','head','5.jpeg','attachment/2020-03-17/','.jpeg','9.3 KB','admin','2020-03-17 07:50:33'),('e5577448f4d44e999f132ef1362bdf84',5,'author','head','165314-.jpeg','attachment/2020-03-16/','.jpeg','35.5 KB','admin','2020-03-16 02:48:05'),('e5daa07d42a74281ad38590bec117bd4',22,'author','head','5-10.jpeg','attachment/2020-03-17/','.jpeg','25.6 KB','admin','2020-03-17 07:36:57'),('ea772f20ae2a48c3b4d777b287533dbf',10,'author','head','3-3.jpg','attachment/2020-03-17/','.jpg','57.4 KB','admin','2020-03-17 07:33:33'),('ecc09be766d341d2b17f1b48bdd54f5b',0,'author','head','165314.jpg','attachment/2020-03-16/','.jpg','36.9 KB','admin','2020-03-16 02:23:39'),('f09ce9a87b414215ab48a04f26134209',13,'book','cover','我的动漫女友们.jpg','attachment/2020-03-18/','.jpg','20.2 KB','admin','2020-03-18 06:14:53'),('f2d974e1c532431e9bde47c9ca035bc3',9,'book','cover','妙医娇妻：总裁老公宠上天.jpg','attachment/2020-03-17/','.jpg','9.8 KB','admin','2020-03-17 08:02:10'),('f3a625564eb440af9ccde9cbd3aad70b',15,'book','cover','极品王爷.jpg','attachment/2020-03-18/','.jpg','21.2 KB','admin','2020-03-18 06:18:00'),('f4b6fa4576ff48aba9cf66e5f3e59050',0,'author','head','timg.jpeg','attachment/2020-03-16/','.jpeg','22.5 KB','admin','2020-03-16 04:49:02'),('f8188e11785d401ead14a66312416e69',13,'author','head','9-1.jpg','attachment/2020-03-17/','.jpg','128.9 KB','admin','2020-03-17 07:34:28'),('fd83cb54740f43b18d676c7926f57465',6,'book','cover','狐色妖娆：女扮男装来修仙.jpg','attachment/2020-03-17/','.jpg','20.8 KB','admin','2020-03-17 07:58:39'),('fd86b5bedd9841479f5b18066d3f567d',16,'book','cover','校草大人万万岁.jpg','attachment/2020-03-18/','.jpg','27.8 KB','admin','2020-03-18 10:36:14');
/*!40000 ALTER TABLE `sys_attachment` ENABLE KEYS */;
UNLOCK TABLES;

