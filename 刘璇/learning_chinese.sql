/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : learning_chinese

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2020-05-17 19:51:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `wordId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('3', '1', '1');

-- ----------------------------
-- Table structure for idioms
-- ----------------------------
DROP TABLE IF EXISTS `idioms`;
CREATE TABLE `idioms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idiom` varchar(255) DEFAULT NULL,
  `wordS` varchar(255) DEFAULT NULL,
  `wordE` varchar(255) DEFAULT NULL,
  `pinyinS` varchar(255) DEFAULT NULL,
  `pinyinE` varchar(255) DEFAULT NULL,
  `paraphrase` varchar(255) DEFAULT NULL,
  `pinyin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=434 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idioms
-- ----------------------------
INSERT INTO `idioms` VALUES ('1', '鹅毛大雪', '鹅', '雪', 'é', 'xuě', '像鹅毛一样的雪花。形容雪下得大而猛。', 'é máo dà xuě');
INSERT INTO `idioms` VALUES ('2', '鸦雀无声', '鸦', '声', 'yā', 'shēng', '连乌鸦和麻雀的叫声都没有。形容自然环境很静或形容人们默不作声；一声不响。鸦：乌鸦；雀：麻雀。 鸦字开头的成语 声字结尾的成语', 'yā què wú shēng');
INSERT INTO `idioms` VALUES ('3', '鸣锣开道', '鸣', '道', 'míng', 'dào', '开道 拼音：míng luó kāi dào释义:鸣锣：敲锣。封建时代官吏出行时；前面差役敲锣；吆喝行人回避。现多比喻为某种事物的产生制造舆论。', 'míng luó kāi dào');
INSERT INTO `idioms` VALUES ('4', '鸡鸣狗盗', '鸡', '盗', 'jī', 'dào', '指微不足道的技能；也指具有这类技能的人。常形容偷偷摸摸等不正当的行为。', 'jī míng gǒu dào');
INSERT INTO `idioms` VALUES ('5', '鸡犬不宁', '鸡', '宁', 'jī', 'níng', '宁：安宁。连鸡狗都不得安宁；形容骚扰得十分厉害。', 'jī quǎn bù níng');
INSERT INTO `idioms` VALUES ('6', '鸡毛蒜皮', '鸡', '皮', 'jī', 'pí', '比喻无关紧要的小事或毫无价值的东西。', 'jī máo suàn pí');
INSERT INTO `idioms` VALUES ('7', '鸟语花香', '鸟', '香', 'niǎo', 'xiāng', '鸟儿啼叫；花儿喷香；形容美好的景色。', 'niǎo yǔ huā xiāng');
INSERT INTO `idioms` VALUES ('8', '鱼目混珠', '鱼', '珠', 'yú', 'zhū', '鱼目：鱼眼睛；混：混同；冒充。用鱼眼来假冒珍珠。形容以假乱真；以次充好。 鱼字开头的成语 珠字结尾的成语', 'yú mù hùn zhū');
INSERT INTO `idioms` VALUES ('9', '魂飞魄散', '魂', '散', 'hún', 'sàn', '魂：灵魂；魄：是指所谓依附形体而显现的精神。指魂飞了；魄也散了。形容极度惊恐。', 'hún fēi pò sàn');
INSERT INTO `idioms` VALUES ('10', '鬼鬼祟祟', '鬼', '祟', 'guǐ', 'suì', '迷信的人指鬼怪；或指鬼怪害人。形容行为偷偷摸摸；不光明正大。', 'guǐ guǐ suì suì');
INSERT INTO `idioms` VALUES ('11', '高谈阔论', '高', '论', 'gāo', 'lùn', '高：大声地；阔：广阔。指志趣高雅、范围广泛的谈论。多含褒义。也指大发议论或不着边际地谈论。多含贬义。', 'gāo tán kuò lùn');
INSERT INTO `idioms` VALUES ('12', '高耸入云', '高', '云', 'gāo', 'yún', '耸：直立，高起。高高地直立，直入云端。形容建筑物、山峰等高峻挺拔。', 'gāo sǒng rù yún');
INSERT INTO `idioms` VALUES ('13', '高瞻远瞩', '高', '瞩', 'gāo', 'zhǔ', '远瞩 拼音：gāo zhān yuǎn zhǔ释义站得高；看得远。多形容目光远大。', 'gāo zhān yuǎn zhǔ');
INSERT INTO `idioms` VALUES ('14', '高朋满座', '高', '座', 'gāo', 'zuò', '高：高贵。高贵的朋友坐满了席位。形容宾客很多。 高字开头的成语 座字结尾的成语', 'gāo péng mǎn zuò');
INSERT INTO `idioms` VALUES ('15', '高山流水', '高', '水', 'gāo', 'shuǐ', '比喻知己或知音。也比喻乐曲高妙。', 'gāo shān liú shuǐ');
INSERT INTO `idioms` VALUES ('16', '骨肉相残', '骨', '残', 'gǔ', 'cán', '比喻自相残杀。', 'gǔ ròu xiāng cán');
INSERT INTO `idioms` VALUES ('17', '骨瘦如柴', '骨', '柴', 'gǔ', 'chái', '瘦得如同柴棒。形容非常消瘦。', 'gǔ shòu rú chái');
INSERT INTO `idioms` VALUES ('18', '骑虎难下', '骑', '下', 'qí', 'xià', '骑在老虎背上不能下来。比喻事情进行到中途；迫于形势；不能停下来只好干到底；进退两难。', 'qí hǔ nán xià');
INSERT INTO `idioms` VALUES ('19', '首屈一指', '首', '指', 'shǒu', 'zhǐ', '扳指头计数；首先弯下大拇指；表示第一。指居第一位。引申为最好的。', 'shǒu qū yī zhǐ');
INSERT INTO `idioms` VALUES ('20', '飞蛾扑火', '飞', '火', 'fēi', 'huǒ', '蛾：像蝴蝶似的昆虫。飞蛾扑到火上。比喻自寻死路；自取灭亡。 飞字开头的成语 火字结尾的成语', 'fēi é pū huǒ');
INSERT INTO `idioms` VALUES ('21', '风驰电掣', '风', '掣', 'fēng', 'chè', '弛：快跑；掣：闪过。像风奔驰；像电闪过。形容非常迅速；急闪而过。也作“风驰电赴”。', 'fēng chí diàn chè');
INSERT INTO `idioms` VALUES ('22', '风雪交加', '风', '加', 'fēng', 'jiā', '风和雪同时袭来。', 'fēng xuě jiāo jiā');
INSERT INTO `idioms` VALUES ('23', '风雨飘摇', '风', '摇', 'fēng', 'yáo', '在风雨里飘浮摇荡。比喻动荡不稳或岌岌可危。', 'fēng yǔ piāo yáo');
INSERT INTO `idioms` VALUES ('24', '风雨无阻', '风', '阻', 'fēng', 'zǔ', '不受刮风下雨的阻碍。指预先约好的事情，一定按期进行。', 'fēng yǔ wú zǔ');
INSERT INTO `idioms` VALUES ('25', '风雨同舟', '风', '舟', 'fēng', 'zhōu', '舟：船。在风雨中同乘在一条船上；一起与风雨搏斗。比喻共同经历患难。', 'fēng yǔ tóng zhōu');
INSERT INTO `idioms` VALUES ('26', '风雨交加', '风', '加', 'fēng', 'jiā', '大风暴雨一齐袭来。形容天气十分恶劣 风字开头的成语 加字结尾的成语', 'fēng yǔ jiāo jiā');
INSERT INTO `idioms` VALUES ('27', '风起云涌', '风', '涌', 'fēng', 'yǒng', '涌：水腾跃。大风刮起来；乌云涌上来。比喻新生事物相继兴起；声势浩大”。也用以形容自然景象不断变化；雄伟壮观。', 'fēng qǐ yún yǒng');
INSERT INTO `idioms` VALUES ('28', '风调雨顺', '风', '顺', 'fēng', 'shùn', '调：调和；配合得均匀合适；顺：适合需要。形容风雨及时；有利于作物的生长。现比喻客观条件有利。', 'fēng tiáo yǔ shùn');
INSERT INTO `idioms` VALUES ('29', '风尘仆仆', '风', '仆', 'fēng', 'pú', '风尘：指旅行。仆：走路劳累的样子。旅行艰辛困顿；行路劳累疲乏。', 'fēng chén pú pú');
INSERT INTO `idioms` VALUES ('30', '风和日丽', '风', '丽', 'fēng', 'lì', '和：柔合；温和。轻风柔和；阳光灿烂。形容天气晴和。', 'fēng hé rì lì');
INSERT INTO `idioms` VALUES ('31', '风吹草动', '风', '动', 'fēng', 'dòng', '微风一吹；草就晃动。比喻轻微的动荡或变故。', 'fēng chuī cǎo dòng');
INSERT INTO `idioms` VALUES ('32', '风卷残云', '风', '云', 'fēng', 'yún', '大风把残留下的浮云一下子刮走。比喻把残存的东西扫荡干净；也用来形容很快把食物吃光。  云字结尾的成语', 'fēng juǎn cán yún');
INSERT INTO `idioms` VALUES ('33', '风云变幻', '风', '幻', 'fēng', 'huàn', '风云：比喻变幻动荡的局势；变幻：变化不定。形容天气变化无常　。现比喻局势复杂；变化急速；难以预料。', 'fēng yún biàn huàn');
INSERT INTO `idioms` VALUES ('34', '颠倒是非', '颠', '非', 'diān', 'fēi', '把对的说成错的；把错的说成对的。指善恶不明或故意歪曲事实。', 'diān dǎo shì fēi');
INSERT INTO `idioms` VALUES ('35', '颜筋柳骨', '颜', '骨', 'yán', 'gǔ', '颜：唐代书法家颜真卿；柳：唐代书法家柳公权。指颜柳两家书法挺劲有力，但风格有所不同。也泛称书法极佳。', 'yán jīn liǔ gǔ');
INSERT INTO `idioms` VALUES ('36', '顾此失彼', '顾', '彼', 'gù', 'bǐ', '顾了这个；顾不了那个。形容头绪繁多；无法兼顾全面。', 'gù cǐ shī bǐ');
INSERT INTO `idioms` VALUES ('37', '顺手牵羊', '顺', '羊', 'shùn', 'yáng', '顺：方便。指顺手把羊牵走。比喻顺便利用可乘之机施展手法或手腕。', 'shùn shǒu qiān yáng');
INSERT INTO `idioms` VALUES ('38', '顶天立地', '顶', '地', 'dǐng', 'dì', '头顶云天；脚踩大地。形容形象高大；气概豪迈。也形容敢作敢为；光明磊落。', 'dǐng tiān lì dì');
INSERT INTO `idioms` VALUES ('39', '面黄肌瘦', '面', '瘦', 'miàn', 'shòu', '面：脸；肌：肌肉；代指身体。面色发黄；身体消瘦。形容人久病体衰或营养不良的样子。 面字开头的成语 瘦字结尾的成语', 'miàn huáng jī shòu');
INSERT INTO `idioms` VALUES ('40', '面如土色', '面', '色', 'miàn', 'sè', '土色：灰黄色。脸色像泥土的颜色一样。形容非常恐惧的样子。', 'miàn rú tǔ sè');
INSERT INTO `idioms` VALUES ('41', '青山绿水', '青', '水', 'qīng', 'shuǐ', '泛称美好山河。', 'qīng shān lǜ shuǐ');
INSERT INTO `idioms` VALUES ('42', '震耳欲聋', '震', '聋', 'zhèn', 'lóng', '耳朵都要振聋了。形容很大；特别响。', 'zhèn ěr yù lóng');
INSERT INTO `idioms` VALUES ('43', '雷电交加', '雷', '加', 'léi', 'jiā', '又是打雷，又是闪电。交加：一起袭来。两种事物同时或错杂出现。', 'léi diàn jiāo jiā');
INSERT INTO `idioms` VALUES ('44', '雷厉风行', '雷', '行', 'léi', 'xíng', '厉：猛烈；行：奔跑；引申为迅速。像打雷那样猛烈；像刮风那样迅速。比喻对法令的执行严厉迅速。也用来形容工作极度紧张；办事果断；行动迅速。 雷字开头的成语 行字结尾的成语', 'léi lì fēng xíng');
INSERT INTO `idioms` VALUES ('45', '雪上加霜', '雪', '霜', 'xuě', 'shuāng', '积雪上又添加寒霜。比喻接连遭受灾难。', 'xuě shàng jiā shuāng');
INSERT INTO `idioms` VALUES ('46', '雨后春笋', '雨', '笋', 'yǔ', 'sǔn', '春雨以后；竹笋长得又多又快。比喻新生事物大量涌现蓬勃发展。', 'yǔ hòu chūn sǔn');
INSERT INTO `idioms` VALUES ('47', '雍容华贵', '雍', '贵', 'yōng', 'guì', '形容态度文雅从容，庄重大方。', 'yōng róng huá guì');
INSERT INTO `idioms` VALUES ('48', '集腋成裘', '集', '裘', 'jí', 'qiú', '集：聚集；腋：狐腋下的皮毛。狐狸腋下的皮毛虽小；但聚集起来就能制成皮衣。比喻积少成多。', 'jí yè chéng qiú');
INSERT INTO `idioms` VALUES ('49', '难能可贵', '难', '贵', 'nán', 'guì', '难能：很难做到；可贵：值得宝贵。本来难做到的事竟然做到了；这是很可贵的。', 'nán néng kě guì');
INSERT INTO `idioms` VALUES ('50', '降龙伏虎', '降', '虎', 'xiáng', 'hǔ', '比喻有极大能力；能够战胜很强的对手或克服很大的困难。 降字开头的成语 虎字结尾的成语', 'xiáng lóng fú hǔ');
INSERT INTO `idioms` VALUES ('51', '阳春白雪', '阳', '雪', 'yáng', 'xuě', '阳春；白雪：是战国时代楚国的艺术性较高难度较大的歌曲；后来泛指高深的；不通俗的文学艺术。', 'yáng chūn bái xuě');
INSERT INTO `idioms` VALUES ('52', '阳奉阴违', '阳', '违', 'yáng', 'wéi', '阳：表面；奉：奉行；遵守；阴：背后；暗里；违：违背。表面上遵从；暗地里违背。', 'yáng fèng yīn wéi');
INSERT INTO `idioms` VALUES ('53', '防患未然', '防', '然', 'fáng', 'rán', '防：防备；患：灾祸；然：这样；如此；未然：没有成为事实；没有这样。在事故或灾难发生之前就采取预防措施。', 'fáng huàn wèi rán');
INSERT INTO `idioms` VALUES ('54', '防不胜防', '防', '防', 'fáng', 'fáng', '防：防备；胜：尽；完全。形容防备不过来。', 'fáng bù shèng fáng');
INSERT INTO `idioms` VALUES ('55', '闻鸡起舞', '闻', '舞', 'wén', 'wǔ', '一听见鸡叫就起床练剑。形容有志报国之士奋发图强；也比喻抓紧时间不懈努力。鸡：鸡鸣报晓。', 'wén jī qǐ wǔ');
INSERT INTO `idioms` VALUES ('56', '闻所未闻', '闻', '闻', 'wén', 'wén', '闻：听到；未：没有。听到的是以前从来没有听过的。形容传说的事物或消息新鲜、奇特。 闻字开头的成语 闻字结尾的成语', 'wén suǒ wèi wén');
INSERT INTO `idioms` VALUES ('57', '闻名遐迩', '闻', '迩', 'wén', 'ěr', '遐：远；迩：近。形容名声很大，远近都知道。', 'wén míng xiá ěr');
INSERT INTO `idioms` VALUES ('58', '闲言碎语', '闲', '语', 'xián', 'yǔ', '①不满意的话；没有根据的话。②与正事无关的话。', 'xián yán suì yǔ');
INSERT INTO `idioms` VALUES ('59', '闭月羞花', '闭', '花', 'bì', 'huā', '闭：躲避；羞：害臊。使月亮见了也躲避起来；花儿见了也自觉羞愧。形容女子容貌极美。', 'bì yuè xiū huā');
INSERT INTO `idioms` VALUES ('60', '门庭若市', '门', '市', 'mén', 'shì', '门：原指宫门；庭：原指朝庭；现指院子；若：好像；市：集市；市场。原来形容宫门里；朝庭上；进谏的人多得像在集市一样；十分热闹。现在形容来的人很多；非常热闹。', 'mén tíng ruò shì');
INSERT INTO `idioms` VALUES ('61', '门可罗雀', '门', '雀', 'mén', 'què', '罗雀：设网捕雀。大门前面可设置网捕雀。形容门庭冷落；来的客人很少。 门字开头的成语 雀字结尾的成语', 'mén kě luó què');
INSERT INTO `idioms` VALUES ('62', '长年累月', '长', '月', 'cháng', 'yuè', '长年：整年；年复一年；累月：一月又一月。形容经历的时间很长很久。', 'cháng nián lěi yuè');
INSERT INTO `idioms` VALUES ('63', '长吁短叹', '长', '叹', 'cháng', 'tàn', '吁：叹气。长声、短声不住地叹气。多为人心情烦闷、郁结不舒的表现。也作“短叹长吁”。', 'cháng xū duǎn tàn');
INSERT INTO `idioms` VALUES ('64', '锦绣河山', '锦', '山', 'jǐn', 'shān', '像锦绣一样美丽无比的祖国河山。形容美好的国土。', 'jǐn xiù hé shān');
INSERT INTO `idioms` VALUES ('65', '锦绣山河', '锦', '河', 'jǐn', 'hé', '高山和河流就像精美鲜艳的丝织品一样。形容美好的国土。', 'jǐn xiù shān hé');
INSERT INTO `idioms` VALUES ('66', '锦上添花', '锦', '花', 'jǐn', 'huā', '在锦锻上面又添小绣花。形容好上加好。', 'jǐn shàng tiān huā');
INSERT INTO `idioms` VALUES ('67', '错落有致', '错', '致', 'cuò', 'zhì', '致：别致；有情趣；错落：参差交错；致：情趣。形容事物的布局虽然参差不齐；但却极有情趣；使人看了有好感。 错字开头的成语 致字结尾的成语', 'cuò luò yǒu zhì');
INSERT INTO `idioms` VALUES ('68', '铁证如山', '铁', '山', 'tiě', 'shān', '形容证据确凿，像山一样不能动摇。', 'tiě zhèng rú shān');
INSERT INTO `idioms` VALUES ('69', '铁石心肠', '铁', '肠', 'tiě', 'cháng', '心肠硬得像铁石头一样。形容心肠很硬；不为感情所动。', 'tiě shí xīn cháng');
INSERT INTO `idioms` VALUES ('70', '铁树开花', '铁', '花', 'tiě', 'huā', '比喻事情非常罕见或极难实现。铁树：也叫苏钱；常绿乔木；好多年才开一次花。', 'tiě shù kāi huā');
INSERT INTO `idioms` VALUES ('71', '金风送爽', '金', '爽', 'jīn', 'shuǎng', '金风：指秋天的风。古时以阴阳五行解释季节，秋为金。秋风带来了凉意。', 'jīn fēng sòng shuǎng');
INSERT INTO `idioms` VALUES ('72', '金蝉脱壳', '金', '壳', 'jīn', 'qiào', '金蝉：金黄色的知了；壳：坚硬的外皮。蝉变为成虫时脱去原来的外壳。比喻用计脱身；使对方不能及时发觉。', 'jīn chán tuō qiào');
INSERT INTO `idioms` VALUES ('73', '金碧辉煌', '金', '煌', 'jīn', 'huáng', '金碧；指国画颜料中的泥金、石青和石绿；辉煌：光辉灿烂。形容建筑物装饰陈设等异常绚丽精彩；光辉灿烂的样子。 金字开头的成语 煌字结尾的成语', 'jīn bì huī huáng');
INSERT INTO `idioms` VALUES ('74', '金玉良言', '金', '言', 'jīn', 'yán', '金、玉：比喻十分珍贵。良言：好话。比喻宝贵的劝告或教诲。', 'jīn yù liáng yán');
INSERT INTO `idioms` VALUES ('75', '金枝玉叶', '金', '叶', 'jīn', 'yè', '原形容花枝叶的美好。后借称帝王子孙。比喻人的身份及其尊贵。', 'jīn zhī yù yè');
INSERT INTO `idioms` VALUES ('76', '里应外合', '里', '合', 'lǐ', 'hé', '应：接应；合：配合。外面攻打与里面接应相结合。', 'lǐ yìng wài hé');
INSERT INTO `idioms` VALUES ('77', '郁郁葱葱', '郁', '葱', 'yù', 'cōng', '郁郁：草木茂盛的样子。形容草木苍翠茂盛。也形容气势美好蓬勃。', 'yù yù cōng cōng');
INSERT INTO `idioms` VALUES ('78', '避重就轻', '避', '轻', 'bì', 'qīng', '避重：指避开要紧的事；就轻：指抓小事情。避开重要的而拣次要的来承担。也指回避要害问题；只谈无关重要的方面。', 'bì zhòng jiù qīng');
INSERT INTO `idioms` VALUES ('79', '避实就虚', '避', '虚', 'bí', 'xū', '实：实力；就：接近；趋向；虚：空虚；虚弱。原指避开敌人的主力；攻击敌人的薄弱环节。现也指办事先找容易突破的地方着手。或谈论问题回避要害。原作“避实击虚”。 避字开头的成语 虚字结尾的成语', 'bí shí jiù xū');
INSERT INTO `idioms` VALUES ('80', '遗臭万年', '遗', '年', 'yí', 'nián', '臭：比喻恶名声；万年：指时间很长久。人死了；可是臭名却永远流传下去；遭人唾骂。', 'yí chòu wàn nián');
INSERT INTO `idioms` VALUES ('81', '龙骧虎步', '龙', '步', 'lóng', 'bù', '象龙马昂首，如老虎迈步。形容气慨威武雄壮。', 'lóng xiāng hǔ bù');
INSERT INTO `idioms` VALUES ('82', '龙马精神', '龙', '神', 'lóng', 'shén', '龙马：传说中形状像龙的马；也指骏马。比喻人的精神健旺。', 'lóng mǎ jīng shén');
INSERT INTO `idioms` VALUES ('83', '龙飞凤舞', '龙', '舞', 'lóng', 'wǔ', '像龙在飞腾；像凤在欢舞。原形容山势蜿蜒曲折；奔放雄伟。旧时迷信；认为是帝王气象。现形容书法笔势飘逸多姿。多指草书。', 'lóng fēi fèng wǔ');
INSERT INTO `idioms` VALUES ('84', '龙跃凤鸣', '龙', '鸣', 'lóng', 'míng', '象龙在腾跃，凤凰在高鸣。比喻才华出众。', 'lóng yuè fèng míng');
INSERT INTO `idioms` VALUES ('85', '龙腾虎跃', '龙', '跃', 'lóng', 'yuè', '腾、跃：跳起；跳跃。像龙那样飞腾；像虎那样跳跃。形容非常活跃的姿态。也作“龙跳虎跃。”', 'lóng téng hǔ yuè');
INSERT INTO `idioms` VALUES ('86', '龙盘虎踞', '龙', '踞', 'lóng', 'jù', '盘：曲、绕；踞：蹲或坐。像龙盘绕；像虎蹲坐。形容地势险要雄伟。 龙字开头的成语 踞字结尾的成语', 'lóng pán hǔ jù');
INSERT INTO `idioms` VALUES ('87', '龙潭虎穴', '龙', '穴', 'lóng', 'xué', '潭：深水坑；穴：动物的窝。龙潜居的深潭；虎藏身的穴窝。比喻极其凶险的地方。', 'lóng tán hǔ xué');
INSERT INTO `idioms` VALUES ('88', '龙争虎斗', '龙', '斗', 'lóng', 'dòu', '龙与虎之间的争斗。形容斗争或竞赛十分激烈紧张。', 'lóng zhēng hǔ dòu');
INSERT INTO `idioms` VALUES ('89', '鼠目寸光', '鼠', '光', 'shǔ', 'guāng', '老鼠的眼睛只能看到一寸远的地方。形容目光短浅；没有远见。', 'shǔ mù cùn guāng');
INSERT INTO `idioms` VALUES ('90', '默默无闻', '默', '闻', 'mò', 'wén', '默默：没有声息；闻：出名。无声无息；不为人知。', 'mò mò wú wén');
INSERT INTO `idioms` VALUES ('91', '黔驴技穷', '黔', '穷', 'qián', 'qióng', '黔：今贵州省；穷：尽。黔地的驴；本领穷尽了。比喻极为有限的一点本领也用尽了。', 'qián lǘ jì qióng');
INSERT INTO `idioms` VALUES ('92', '鹦鹉学舌', '鹦', '舌', 'yīng', 'shé', '像鹦鹉一样学人说话。常比喻跟着人家的话说；或指搬嘴学舌。 鹦字开头的成语 舌字结尾的成语', 'yīng wǔ xué shé');
INSERT INTO `idioms` VALUES ('93', '鹤立鸡群', '鹤', '群', 'hè', 'qūn', '像仙鹤立在鸡群之中。比喻才能或仪表出众。', 'hè lì jī qūn');
INSERT INTO `idioms` VALUES ('94', '鹤发鸡皮', '鹤', '皮', 'hè', 'pí', '鹤发：白发；鸡皮：形容皮肤有皱纹。皮肤发皱，头发苍白。形容老人年迈的相貌。', 'hè fà jī pí');
INSERT INTO `idioms` VALUES ('95', '鹤发童颜', '鹤', '颜', 'hè', 'yán', '鹤发：白白的头发；童颜：红红的面色。满头白发；面色像孩童一样红润。形容老年人气色好；有精神。', 'hè fà tóng yán');
INSERT INTO `idioms` VALUES ('96', '鹏程万里', '鹏', '里', 'péng', 'lǐ', '鹏：指传说中的大鸟；能飞行万里；程：里程。大鸟飞行的路程万里之遥。比喻前程远大。', 'péng chéng wàn lǐ');
INSERT INTO `idioms` VALUES ('97', '道听途说', '道', '说', 'dào', 'shuō', '道、途：路。路上听说来的；又在路上传播。指随便传说不可靠的消息；或指没有根据的消息。', 'dào tīng tú shuō');
INSERT INTO `idioms` VALUES ('98', '遍地开花', '遍', '花', 'biàn', 'huā', '遍：普及；到处。比喻普遍推广；全面地展开。', 'biàn dì kāi huā');
INSERT INTO `idioms` VALUES ('99', '迫不及待', '迫', '待', 'pò', 'dài', '迫：急迫；待：等待。急迫得不再等待。形容心情非常着急。', 'pò bù jí dài');
INSERT INTO `idioms` VALUES ('100', '迥然不同', '迥', '同', 'jiǒng', 'tóng', '迥然：差距很大的样子。大不相同；相差太远。形容彼此完全不同。', 'jiǒng rán bù tóng');
INSERT INTO `idioms` VALUES ('101', '远交近攻', '远', '攻', 'yuǎn', 'gōng', '原指对远方国家联合；对邻近国家攻占的外交策略。后来指利用关系转较远的力量来攻击眼前对手的处世手法。', 'yuǎn jiāo jìn gōng');
INSERT INTO `idioms` VALUES ('102', '还我河山', '还', '山', 'huán', 'shān', '表示决心从侵略者手中夺回本属于自己的国土。 还字开头的成语 山字结尾的成语', 'huán wǒ hé shān');
INSERT INTO `idioms` VALUES ('103', '过眼烟云', '过', '云', 'guò', 'yún', '如同烟云在眼前飘过。比喻身外之物和很快就消失的事物。', 'guò yǎn yān yún');
INSERT INTO `idioms` VALUES ('104', '过眼云烟', '过', '烟', 'guò', 'yān', '从眼前飘过的云烟。原比喻身外之物，不必重视。后比喻很快就消失的事物。', 'guò yǎn yún yān');
INSERT INTO `idioms` VALUES ('105', '过时黄花', '过', '花', 'guò', 'huā', '黄花：菊花。重阳节后的菊花。比喻过了时的或失去意义的事物。', 'guò shí huáng huā');
INSERT INTO `idioms` VALUES ('106', '轻如鸿毛', '轻', '毛', 'qīng', 'máo', '鸿毛：大雁的毛。比大雁的毛还要轻。比喻非常轻微或毫无价值。', 'qīng rú hóng máo');
INSERT INTO `idioms` VALUES ('107', '转危为安', '转', '安', 'zhuǎn', 'ān', '由危险转为平安。危：危险。', 'zhuǎn wēi wéi ān');
INSERT INTO `idioms` VALUES ('108', '车水马龙', '车', '龙', 'chē', 'lóng', '车络绎不绝；有如流水；马首尾相接；好像游龙。形容沿途车马很多；成群结队；繁华热闹的场面。也作“马龙车水”。 车字开头的成语 龙字结尾的成语', 'chē shuǐ mǎ lóng');
INSERT INTO `idioms` VALUES ('109', '足智多谋', '足', '谋', 'zú', 'móu', '足够的才智；大量的计谋。形容善于动脑筋出主意。谋：计谋。', 'zú zhì duō móu');
INSERT INTO `idioms` VALUES ('110', '起死回生', '起', '生', 'qǐ', 'shēng', '把快要死的人救活。形容医术高明。也指将没有多少希望的事情挽救回来。', 'qǐ sǐ huí shēng');
INSERT INTO `idioms` VALUES ('111', '走南闯北', '走', '北', 'zǒu', 'běi', '指走过南方北方不少地方。也泛指闯荡。', 'zǒu nán chuǎng běi');
INSERT INTO `idioms` VALUES ('112', '赤胆忠心', '赤', '心', 'chì', 'xīn', '赤：赤诚、真诚；忠：忠诚。形容很忠诚；有时也指非常真诚的心。也作“忠心赤胆”。', 'chì dǎn zhōng xīn');
INSERT INTO `idioms` VALUES ('113', '贪生怕死', '贪', '死', 'tān', 'sǐ', '贪：贪恋。贪图生存；惧害死亡。形容为了活命而失去正义的原则。', 'tān shēng pà sǐ');
INSERT INTO `idioms` VALUES ('114', '负荆请罪', '负', '罪', 'fù', 'zuì', '负：背着；荆：荆条；古时用来抽打犯人的刑具。背着荆条向对方请罪。表示主动向人认错赔罪；请求责罚。 负字开头的成语 罪字结尾的成语', 'fù jīng qǐng zuì');
INSERT INTO `idioms` VALUES ('115', '豪言壮语', '豪', '语', 'háo', 'yǔ', '豪：豪迈；壮：雄壮。指言语豪迈雄壮。', 'háo yán zhuàng yǔ');
INSERT INTO `idioms` VALUES ('116', '豁达大度', '豁', '度', 'huò', 'dù', '豁达：开朗；大度：气量大。形容人心的开阔；有度量；能容人。', 'huò dá dà dù');
INSERT INTO `idioms` VALUES ('117', '豁然开朗', '豁', '朗', 'huò', 'lǎng', '豁然：开阔敞亮的样子；开朗：地方开阔；光线充足、明亮。指一下子出现了开阔明亮的境界。也形容一下子明白了某种道理；心情十分舒畅。', 'huò rán kāi lǎng');
INSERT INTO `idioms` VALUES ('118', '谨言慎行', '谨', '行', 'jǐn', 'xíng', '谨：小心；慎：谨慎。小心谨慎地说话、做事。', 'jǐn yán shèn xíng');
INSERT INTO `idioms` VALUES ('119', '谈虎色变', '谈', '变', 'tán', 'biàn', '色：脸色；神色。原指被老虎咬过的人一谈起老虎；吓得脸色都变了。后比喻一提起可怕的事；就情绪紧张。', 'tán hǔ sè biàn');
INSERT INTO `idioms` VALUES ('120', '谈笑风生', '谈', '生', 'tán', 'shēng', '形容谈话时有说有笑；饶有兴趣；气氛热烈。风生：有兴致；很风趣。 谈字开头的成语 生字结尾的成语', 'tán xiào fēng shēng');
INSERT INTO `idioms` VALUES ('121', '谄上欺下', '谄', '下', 'chǎn', 'xià', '谄：讨好，奉承；欺：欺压。讨好上司，欺压下级。', 'chǎn shàng qī xià');
INSERT INTO `idioms` VALUES ('122', '调虎离山', '调', '山', 'diào', 'shān', '设计让老虎离开原来的山头。比喻用计谋引诱对方离开原来有利的地势。', 'diào hǔ lí shān');
INSERT INTO `idioms` VALUES ('123', '调兵遣将', '调', '将', 'diào', 'jiàng', '调动军队；派遣将领；或是调动、安排人力。', 'diào bīng qiǎn jiàng');
INSERT INTO `idioms` VALUES ('124', '说一不二', '说', '二', 'shuō', 'èr', '指说话算数；说了就不更改。', 'shuō yī bù èr');
INSERT INTO `idioms` VALUES ('125', '语重心长', '语', '长', 'yǔ', 'cháng', '重：郑重。恳切话说得诚恳；有分量；心意深长。', 'yǔ zhòng xīn cháng');
INSERT INTO `idioms` VALUES ('126', '评头论足', '评', '足', 'píng', 'zú', '原指轻浮地议论妇女的容貌。现也比喻任意挑剔。 评字开头的成语 足字结尾的成语', 'píng tóu lùn zú');
INSERT INTO `idioms` VALUES ('127', '誓死不二', '誓', '二', 'shì', 'èr', '誓死：立下志愿，至死不变。至死也不变心。形容意志坚定专一。', 'shì sǐ bù èr');
INSERT INTO `idioms` VALUES ('128', '视死如归', '视', '归', 'shì', 'guī', '把死看得好像回家一样平常。形容为了正义事业；不怕牺牲生命。', 'shì sǐ rú guī');
INSERT INTO `idioms` VALUES ('129', '规行矩步', '规', '步', 'guī', 'bù', '比喻行动谨慎规范；严格按规章制度办事。也比喻墨守陈规；不知变通。规、矩：原为测绘工具；这里比喻为原则、规矩。', 'guī xíng jǔ bù');
INSERT INTO `idioms` VALUES ('130', '观者如云', '观', '云', 'guān', 'yún', '观看的人就象行云一样密集。形容围看的人非常多。', 'guān zhě rú yún');
INSERT INTO `idioms` VALUES ('131', '见多识广', '见', '广', 'jiàn', 'shí', '识：知道。看到的多；知道的广。形容资格较老；经验丰富；知识广博。 见字开头的成语 广字结尾的成语', 'jiàn duō shí');
INSERT INTO `idioms` VALUES ('132', '见利忘义', '见', '义', 'jiàn', 'yì', '见到有利可图就不顾道义。形容人贪财自私。', 'jiàn lì wàng yì');
INSERT INTO `idioms` VALUES ('133', '衣冠禽兽', '衣', '兽', 'yī', 'shòu', '穿衣服戴帽子的畜牲（衣：穿衣；冠：戴帽）。指品德败坏；行为像禽兽一样卑劣的人。', 'yī guān qín shòu');
INSERT INTO `idioms` VALUES ('134', '街头巷尾', '街', '尾', 'jiē', 'wěi', '指大街小巷。', 'jiē tóu xiàng wěi');
INSERT INTO `idioms` VALUES ('135', '行同狗彘', '行', '彘', 'xíng', 'zhì', '旧时指人无耻，行为和猪狗一样。', 'xíng tóng gǒu zhì');
INSERT INTO `idioms` VALUES ('136', '行云流水', '行', '水', 'xíng', 'shuǐ', '形容文章自然不受拘束；就像飘浮着的云和流动着的水一样。', 'xíng yún liú shuǐ');
INSERT INTO `idioms` VALUES ('137', '血雨腥风', '血', '风', 'xuè', 'fēng', '下着鲜血的雨；刮着腥味的风。比喻形势、时局的险恶。 血字开头的成语 风字结尾的成语', 'xuè yǔ xīng fēng');
INSERT INTO `idioms` VALUES ('138', '血流成河', '血', '河', 'xuè', 'hé', '形容被杀的人极多。', 'xuè liú chéng hé');
INSERT INTO `idioms` VALUES ('139', '蠢蠢欲动', '蠢', '动', 'chǔn', 'dòng', '蠢蠢：爬虫蠕动的样子。形容像虫子一样开始动弹。比喻敌人策划准备进攻；或坏人准备捣乱破坏。', 'chǔn chǔn yù dòng');
INSERT INTO `idioms` VALUES ('140', '螳臂挡车', '螳', '车', 'táng', 'chē', '比喻自不量力，招致失败。同“螳臂当车”。', 'táng bì dǎng chē');
INSERT INTO `idioms` VALUES ('141', '蝇头微利', '蝇', '利', 'yíng', 'lì', '如同苍蝇头那样的小利。比喻非常微小的利润。', 'yíng tóu wēi lì');
INSERT INTO `idioms` VALUES ('142', '蜻蜓点水', '蜻', '水', 'qīng', 'shuǐ', '蜻蜓刚刚接触水面又迅速起来。比喻做事不认真；敷衍了事。', 'qīng tíng diǎn shuǐ');
INSERT INTO `idioms` VALUES ('143', '蜂拥而至', '蜂', '至', 'fēng', 'zhì', '像一窝蜂似地一拥而来。形容很多人乱哄哄地朝一个地方聚拢。 蜂字开头的成语 至字结尾的成语', 'fēng yōng ér zhì');
INSERT INTO `idioms` VALUES ('144', '蛛丝马迹', '蛛', '迹', 'zhū', 'jì', '蜘蛛丝；马蹄痕。比喻隐约可寻的线索。蛛丝：蜘蛛丝；马迹：马蹄印。', 'zhū sī mǎ jì');
INSERT INTO `idioms` VALUES ('145', '蚕食鲸吞', '蚕', '吞', 'cán', 'tūn', '食：吃；吞：整个儿咽下去。像蚕啃桑叶一样一点一点来；或像鲸鱼吃食一样大口大口吞。比喻强国用逐步侵占或一举吞并的方式侵略弱国领土。', 'cán shí jīng tūn');
INSERT INTO `idioms` VALUES ('146', '虚情假意', '虚', '意', 'xū', 'yì', '虚假的情意。指虚伪做作；假装殷勤。', 'xū qíng jiǎ yì');
INSERT INTO `idioms` VALUES ('147', '虚怀若谷', '虚', '谷', 'xū', 'gǔ', '谦虚的胸怀像深广的山谷。形容非常谦虚。谷：山谷。', 'xū huái ruò gǔ');
INSERT INTO `idioms` VALUES ('148', '虎视眈眈', '虎', '眈', 'hǔ', 'dān', '眈眈：注视的样子。像老虎一样凶狠地注视着。形容心怀不良；伺机攫取。', 'hǔ shì dān dān');
INSERT INTO `idioms` VALUES ('149', '虎背熊腰', '虎', '腰', 'hǔ', 'yāo', '如虎般宽厚的背；似熊样粗壮的腰。形容人的身体魁梧强壮。', 'hǔ bèi xióng yāo');
INSERT INTO `idioms` VALUES ('150', '虎头蛇尾', '虎', '尾', 'hǔ', 'wěi', '头大像老虎一样；尾巴像蛇一样细。比喻做事有始无终；起初声势很大；后来劲头很小。 虎字开头的成语 尾字结尾的成语', 'hǔ tóu shé wěi');
INSERT INTO `idioms` VALUES ('151', '虎口拔牙', '虎', '牙', 'hǔ', 'yá', '在老虎嘴里拔牙。比喻冒着极大危险去做某一事情。', 'hǔ kǒu bá yá');
INSERT INTO `idioms` VALUES ('152', '虎口余生', '虎', '生', 'hǔ', 'shēng', '从老虎嘴里逃出的生命。比喻经历极大的危险；侥幸保全了性命。', 'hǔ kǒu yú shēng');
INSERT INTO `idioms` VALUES ('153', '藏头露尾', '藏', '尾', 'cáng', 'wěi', '头藏起来；却把尾巴露出来了。比喻遮遮掩掩或躲躲闪闪；不肯把真实情况全暴露出来。也作“露尾藏头”。', 'cáng tóu lù wěi');
INSERT INTO `idioms` VALUES ('154', '蔚然成风', '蔚', '风', 'wèi', 'fēng', '形容某件事发展盛行；形成一种良好风气。蔚然：草木茂盛的样子。', 'wèi rán chéng fēng');
INSERT INTO `idioms` VALUES ('155', '蓬头垢面', '蓬', '面', 'péng', 'miàn', '蓬：蓬草；散乱　；垢：污秽；脏。形容头发散乱脸上很脏。', 'péng tóu gòu miàn');
INSERT INTO `idioms` VALUES ('156', '蒸蒸日上', '蒸', '上', 'zhēng', 'shàng', '蒸蒸：一天天地向上发展。形容发展速度快。 蒸字开头的成语 上字结尾的成语', 'zhēng zhēng rì shàng');
INSERT INTO `idioms` VALUES ('157', '落落大方', '落', '方', 'luò', 'fāng', '落落：坦率开朗；举止潇洒自然。形容言谈举止自然大方；不拘谨。', 'luò luò dà fāng');
INSERT INTO `idioms` VALUES ('158', '莺歌燕舞', '莺', '舞', 'yīng', 'wǔ', '黄莺歌唱；燕子跳舞。形容春光明媚的景象。', 'yīng gē yàn wǔ');
INSERT INTO `idioms` VALUES ('159', '荣辱与共', '荣', '共', 'róng', 'gòng', '两者共同分享荣耀和耻辱。指关系十分密切', 'róng rǔ yǔ gòng');
INSERT INTO `idioms` VALUES ('160', '茫然若失', '茫', '失', 'máng', 'shī', '茫然：失意的样子；若失：好像失去了什么东西。形容精神不集中；若有所失的样子。', 'máng rán ruò shī');
INSERT INTO `idioms` VALUES ('161', '苦思冥想', '苦', '想', 'kǔ', 'xiǎng', '绞尽脑汁，深沉地思索。', 'kǔ sī míng xiǎng');
INSERT INTO `idioms` VALUES ('162', '苦尽甘来', '苦', '来', 'kǔ', 'lái', '尽：终结；甘：甜；美好。比喻艰苦的日子已经过去；美好的时光已经到来。 苦字开头的成语 来字结尾的成语', 'kǔ jìn gān lái');
INSERT INTO `idioms` VALUES ('163', '苦口婆心', '苦', '心', '婆心', 'xīn', '苦口：不厌其烦地反复劝说与开导；婆心：老婆婆的心肠；指好意、善意。好心好意；不厌其烦地劝说或开导。形容耐心恳切地再三规劝。', '婆心 拼音:kǔ kǒu pó xīn');
INSERT INTO `idioms` VALUES ('164', '若隐若现', '若', '现', 'ruò', 'xiàn', '好像隐没了；又好像现出了。形容隐隐约约、依稀可见的状态。', 'ruò yǐn ruò xiàn');
INSERT INTO `idioms` VALUES ('165', '花言巧语', '花', '语', 'huā', 'yǔ', '原指铺张修饰而无实际内容的言语或文辞。后指虚假而动听的话；也指说虚假而动听的话。', 'huā yán qiǎo yǔ');
INSERT INTO `idioms` VALUES ('166', '花花世界', '花', '界', 'huā', 'jiè', '指热闹繁华的地方或灯红酒绿寻欢作乐的场所。也泛指人世间。含贬义。', 'huā huā shì jiè');
INSERT INTO `idioms` VALUES ('167', '花红柳绿', '花', '绿', 'huā', 'lǜ', '红红的花儿；绿绿的柳条。形容春天明媚的景色；也形容颜色鲜艳多彩。', 'huā hóng liǔ lǜ');
INSERT INTO `idioms` VALUES ('168', '花枝招展', '花', '展', 'huā', 'zhǎn', '招展：迎风摆动的样子。像花枝迎风摆动一样。形容妇女打扮得十分漂亮。 花字开头的成语 展字结尾的成语', 'huā zhī zhāo zhǎn');
INSERT INTO `idioms` VALUES ('169', '花团锦簇', '花', '簇', 'huā', 'cù', '锦：有彩色花纹的丝织品；簇：丛聚；聚成一团。指花朵、锦绣汇聚在一起。原指华丽高贵的服饰。形容五彩缤纷、繁华艳丽的景色。也形容衣饰华美的人群或文章辞藻华丽。', 'huā tuán jǐn cù');
INSERT INTO `idioms` VALUES ('170', '舍近求远', '舍', '远', 'shě', 'yuǎn', '舍：放弃；求：追求。舍弃近便的；追求遥远的。', 'shě jìn qiú yuǎn');
INSERT INTO `idioms` VALUES ('171', '舍生忘死', '舍', '死', 'shě', 'sǐ', '不把个人的生死放在心上。舍：舍弃。', 'shě shēng wàng sǐ');
INSERT INTO `idioms` VALUES ('172', '舍死忘生', '舍', '生', 'shě', 'shēng', '舍死：舍得牺牲；忘生：忘掉性命。不把个人的生死放在心上。', 'shě sǐ wàng shēng');
INSERT INTO `idioms` VALUES ('173', '舍本求末', '舍', '末', 'shě', 'mò', '舍：舍弃；求：追求。抛弃根本的、主要的，而去追求枝节的、次要的。比喻不抓根本环节，而只在枝节问题上下功夫。', 'shě běn qiú mò');
INSERT INTO `idioms` VALUES ('174', '舍己为人', '舍', '人', 'shě', 'rén', '舍弃自己的利益而去帮助别人。 舍字开头的成语 人字结尾的成语', 'shě jǐ wèi rén');
INSERT INTO `idioms` VALUES ('175', '自鸣得意', '自', '意', 'zì', 'yì', '自己表示得意。形容自我欣赏。鸣：表达；表示。', 'zì míng dé yì');
INSERT INTO `idioms` VALUES ('176', '自高自大', '自', '大', 'zì', 'dà', '认为自己又高又大。形容自以为了不起。', 'zì gāo zì dà');
INSERT INTO `idioms` VALUES ('177', '自轻自贱', '自', '贱', 'zì', 'jiàn', '轻、贱：轻视。卑视自己；不知自重。', 'zì qīng zì jiàn');
INSERT INTO `idioms` VALUES ('178', '自言自语', '自', '语', 'zì', 'yǔ', '言、语：说。自己跟自己说话。', 'zì yán zì yǔ');
INSERT INTO `idioms` VALUES ('179', '自知之明', '自', '明', 'zì', 'míng', '自己了解自己这样的明智。指对自己的（优）缺点了解得透彻。明：明智。', 'zì zhī zhī míng');
INSERT INTO `idioms` VALUES ('180', '自由自在', '自', '在', 'zì', 'zài', '形容没有拘束；十分安闲舒适。 自字开头的成语 在字结尾的成语', 'zì yóu zì zài');
INSERT INTO `idioms` VALUES ('181', '自生自灭', '自', '灭', 'zì', 'miè', '自然地生长；自然地消灭。形容任其自然；无人过问。', 'zì shēng zì miè');
INSERT INTO `idioms` VALUES ('182', '自暴自弃', '自', '弃', 'zì', 'qì', '自己糟蹋自己；自己鄙弃自己。形容不知自爱；甘于落后。暴；糟蹋；弃：鄙弃。', 'zì bào zì qì');
INSERT INTO `idioms` VALUES ('183', '自我陶醉', '自', '醉', 'zì', 'zuì', '形容不适当地自我欣赏。陶醉：沉醉在某种境界或情绪中。', 'zì wǒ táo zuì');
INSERT INTO `idioms` VALUES ('184', '自强不息', '自', '息', 'zì', 'xī', '自觉地努力向上；永不停步。息：停止。', 'zì qiáng bù xī');
INSERT INTO `idioms` VALUES ('185', '自圆其说', '自', '说', 'zì', 'shuō', '自己把论点表达得圆满、周全。形容不露破绽。圆：使圆满；说：观点；论点。', 'zì yuán qí shuō');
INSERT INTO `idioms` VALUES ('186', '自命不凡', '自', '凡', 'zì', 'fán', '自称自己不平常（凡：平凡；平常）。形容自高。  凡字结尾的成语', 'zì mìng bù fán');
INSERT INTO `idioms` VALUES ('187', '自作自受', '自', '受', 'zì', 'shòu', '自己做了蠢事自己受累。', 'zì zuò zì shòu');
INSERT INTO `idioms` VALUES ('188', '膘肥体壮', '膘', '壮', 'biāo', 'zhuàng', '形容牲畜肥壮结实。', 'biāo féi tǐ zhuàng');
INSERT INTO `idioms` VALUES ('189', '腾空而起', '腾', '起', 'téng', 'qǐ', '腾空：向天空飞升。向高空升起。', 'téng kōng ér qǐ');
INSERT INTO `idioms` VALUES ('190', '腾云驾雾', '腾', '雾', 'téng', 'wù', '神话描写神仙、妖魔或得道的人可以乘着云雾在空中飞行。也形容人在身体、精神处于不正常状态的举止。', 'téng yún jià wù');
INSERT INTO `idioms` VALUES ('191', '脱胎换骨', '脱', '骨', 'tuō', 'gǔ', '原为道教用语。指修道者得道以后；就脱凡胎为圣胎；换凡骨为仙骨。现比喻通过教育；思想得到彻底改造。', 'tuō tāi huàn gǔ');
INSERT INTO `idioms` VALUES ('192', '能屈能伸', '能', '伸', 'néng', 'shēn', '屈：弯曲；伸：伸直。能弯曲也能伸直。指人根据环境变化的需要既能忍受委屈；又能挺直腰板；施展抱负。 能字开头的成语 伸字结尾的成语', 'néng qū néng shēn');
INSERT INTO `idioms` VALUES ('193', '胸无点墨', '胸', '墨', 'xiōng', 'mò', '肚子里没有一点墨水。旧指人没有文化。点：一点；比喻极小；墨：墨水；比喻学问。', 'xiōng wú diǎn mò');
INSERT INTO `idioms` VALUES ('194', '胡言乱语', '胡', '语', 'hú', 'yǔ', '指没有根据，不符实际的瞎说，或说胡话。', 'hú yán luàn yǔ');
INSERT INTO `idioms` VALUES ('195', '胡思乱想', '胡', '想', 'hú', 'xiǎng', '胡：乱；随意。不切实际；毫无根据地瞎想。', 'hú sī luàn xiǎng');
INSERT INTO `idioms` VALUES ('196', '胆小如鼠', '胆', '鼠', 'dǎn', 'shǔ', '胆子小得像老鼠一般。形容人胆小怕事。', 'dǎn xiǎo rú shǔ');
INSERT INTO `idioms` VALUES ('197', '胆大包天', '胆', '天', 'dǎn', 'tiān', '形容胆量极大（多指做坏事）。现多含贬义。', 'dǎn dà bāo tiān');
INSERT INTO `idioms` VALUES ('198', '肝胆相照', '肝', '照', 'gān', 'zhào', '形容对人忠诚；用真心相待。肝胆：比喻真诚的心。', 'gān dǎn xiāng zhào');
INSERT INTO `idioms` VALUES ('199', '肆无忌惮', '肆', '惮', 'sì', 'dàn', '肆：放肆；任意而行；忌惮：惧怕；畏惧。任意妄为；一点顾忌、畏惧也没有。 肆字开头的成语 惮字结尾的成语', 'sì wú jì dàn');
INSERT INTO `idioms` VALUES ('200', '耿耿于怀', '耿', '怀', 'gěng', 'huái', '耿耿；形容有心事。老是放在心里；不能忘怀。形容有无法排遣的心事。', 'gěng gěng yú huái');
INSERT INTO `idioms` VALUES ('201', '耳闻目睹', '耳', '睹', 'ěr', 'dǔ', '闻；听见；睹：看见。亲耳听见亲眼看到。', 'ěr wén mù dǔ');
INSERT INTO `idioms` VALUES ('202', '老态龙钟', '老', '钟', 'lǎo', 'zhōng', '老态：老年人的体态；龙钟：行动不灵活。形容年老体衰；动作迟缓。', 'lǎo tài lóng zhōng');
INSERT INTO `idioms` VALUES ('203', '美如冠玉', '美', '玉', 'měi', 'yù', '原比喻只是外表好看。后形容男子长相漂亮。', 'měi rú guān yù');
INSERT INTO `idioms` VALUES ('204', '美不胜收', '美', '收', 'měi', 'shōu', '胜：尽；收：接收；领略。形容美好的事物、景色非常多；人们一时间领略、欣赏不过来。', 'měi bù shèng shōu');
INSERT INTO `idioms` VALUES ('205', '羊肠小道', '羊', '道', 'yáng', 'dào', '原指太行山上一条小道。后形容狭窄曲折而又险峻的山路。 羊字开头的成语 道字结尾的成语', 'yáng cháng xiǎo dào');
INSERT INTO `idioms` VALUES ('206', '罪魁祸首', '罪', '首', 'zuì', 'shǒu', '作恶犯罪的头子（魁、首：头目）。指坏事的根子。', 'zuì kuí huò shǒu');
INSERT INTO `idioms` VALUES ('207', '缩手缩脚', '缩', '脚', 'suō', 'jiǎo', '形容做事胆小、顾虑多；不敢放手。缩：收缩。', 'suō shǒu suō jiǎo');
INSERT INTO `idioms` VALUES ('208', '绿草如茵', '绿', '茵', 'lǜ', 'yīn', '绿油油的草好象地上铺的褥子。常指可供临时休憩的草地。亦作“碧草如茵”。', 'lǜ cǎo rú yīn');
INSERT INTO `idioms` VALUES ('209', '绿水青山', '绿', '山', 'lǜ', 'shān', '泛称美好山河。', 'lǜ shuǐ qīng shān');
INSERT INTO `idioms` VALUES ('210', '绿林好汉', '绿', '汉', 'lù', 'hàn', '绿林：古代山名；在今湖北省大洪山一带。原指聚集山林反抗封建统治阶级的人们。', 'lù lín hǎo hàn');
INSERT INTO `idioms` VALUES ('211', '绰绰有余', '绰', '余', 'chuò', 'yǒuyú', '绰绰：宽裕的样子。形容人、物、财、能力等很宽裕；用不完。也作“绰绰有余”、“绰有宽裕”。 绰字开头的成语 余字结尾的成语', 'chuò chuò yǒuyú');
INSERT INTO `idioms` VALUES ('212', '绰约多姿', '绰', '姿', 'huò', 'zī', '绰约：姿态优美的样子。形容女子体态的美。', 'huò yuē duō zī');
INSERT INTO `idioms` VALUES ('213', '绝无仅有', '绝', '有', 'jué', 'yǒu', '绝：绝对；仅：只。只有这一个；此外不会再有。形容极其少有。', 'jué wú jǐn yǒu');
INSERT INTO `idioms` VALUES ('214', '络绎不绝', '络', '绝', 'luò', 'jué', '络绎：前后相连；连续不断。不绝：也是不断之意。形容行人、车马、船只等来往频繁；连续不断。也作“络绎不断”。', 'luò yì bù jué');
INSERT INTO `idioms` VALUES ('215', '绚丽多彩', '绚', '彩', 'xuàn', 'cǎi', '形容色彩华丽', 'xuàn lì duō cǎi');
INSERT INTO `idioms` VALUES ('216', '绘声绘色', '绘', '色', 'huì', 'huìsè', '绘：指绘；描摹。形容讲述或描写事物的情景；深刻入微；非常生动、逼真。', 'huì shēng huìsè');
INSERT INTO `idioms` VALUES ('217', '纸上谈兵', '纸', '兵', 'zhǐ', 'bīng', '在纸上谈论用兵（兵：打仗；用兵）。比喻不解决实际问题的空谈。 纸字开头的成语 兵字结尾的成语', 'zhǐ shàng tán bīng');
INSERT INTO `idioms` VALUES ('218', '纷至沓来', '纷', '来', 'fēn', 'lái', '纷：多；杂乱；沓：重复；多。形容接连不断地到来。', 'fēn zhì tà lái');
INSERT INTO `idioms` VALUES ('219', '红颜薄命', '红', '命', 'hóng', 'mìng', '旧指美貌女子不是早死；就遇不到好人或生活多磨难。红颜：美貌女子；薄命：命运不好。', 'hóng yán bó mìng');
INSERT INTO `idioms` VALUES ('220', '精卫填海', '精', '海', 'jīng', 'hǎi', '精卫：古代神话中的小鸟名。古代神话；炎帝的女儿在东海淹死；化为精卫鸟；每天衔西山的木石来填东海。后用来比喻不畏困难；意志坚决。', 'jīng wèi tián hǎi');
INSERT INTO `idioms` VALUES ('221', '粗枝大叶', '粗', '叶', 'cū', 'yè', '原指花草树木的枝茎粗壮。原比喻简略或概括。现多指工作粗糙；做事不认真、不细致；不研究事物各方面的具体情况。又比喻不周密、不详细或比喻粗略的轮廓。', 'cū zhī dà yè');
INSERT INTO `idioms` VALUES ('222', '粉身碎骨', '粉', '骨', 'fěn', 'gǔ', '全身粉碎。多指为了某种目的而不惜牺牲生命。也比喻彻底遭到失败或遭遇极大的磨难。', 'fěn shēn suì gǔ');
INSERT INTO `idioms` VALUES ('223', '管中窥豹', '管', '豹', 'guǎn', 'bào', '从竹管的小孔中看豹；只看到豹身上的一块斑痕。比喻没有看到事物的全貌；只是片面了解。也比喻可以从观察到的部分推测全貌。 管字开头的成语 豹字结尾的成语', 'guǎn zhōng kuī bào');
INSERT INTO `idioms` VALUES ('224', '笨鸟先飞', '笨', '飞', 'bèn', 'fēi', '笨拙的鸟先飞起来；比喻能力差的人做事时；害怕落到别人后面；比别人先着手做事。也作“夯鸟先飞”。', 'bèn niǎo xiān fēi');
INSERT INTO `idioms` VALUES ('225', '笨手笨脚', '笨', '脚', 'bèn', 'jiǎo', '形容动作不灵活', 'bèn shǒu bèn jiǎo');
INSERT INTO `idioms` VALUES ('226', '笑容可掬', '笑', '掬', 'xiào', 'jū', '脸上的笑容好像可以用手捧起来一样。形容笑容满面。掬：用双手捧起来。', 'xiào róng kě jū');
INSERT INTO `idioms` VALUES ('227', '穿针引线', '穿', '线', 'chuān', 'xiàn', '原指在男女之间进行的撮合；现常用来比喻从中联系、牵合、拉拢；使双方接通关系。', 'chuān zhēn yǐn xiàn');
INSERT INTO `idioms` VALUES ('228', '空前绝后', '空', '后', 'kōng', 'hòu', '空：空白；绝：断绝。以前没有过；以后也没有。指从古到今非常突出；独一无二的事物。', 'kōng qián jué hòu');
INSERT INTO `idioms` VALUES ('229', '稳如泰山', '稳', '山', 'wěn', 'shān', '稳：稳固。稳固得像泰山一样。形容极其稳固；不可动摇。', 'wěn rú tài shān');
INSERT INTO `idioms` VALUES ('230', '程门立雪', '程', '雪', 'chéng', 'xuě', '旧指学生恭敬受教。比喻尊师。', 'chéng mén lì xuě');
INSERT INTO `idioms` VALUES ('231', '积少成多', '积', '多', 'jī', 'duō', '一点一滴的积累；就会从少变多。', 'jī shǎo chéng duō');
INSERT INTO `idioms` VALUES ('232', '秋高气爽', '秋', '爽', 'qiū', 'shuǎng', '形容秋季天空晴朗；气候凉爽宜人。', 'qiū gāo qì shuǎng');
INSERT INTO `idioms` VALUES ('233', '神采奕奕', '神', '奕', 'shén', 'yì', '形容精神饱满；容光焕发。神采：人面部的神气和光彩。奕奕：精神焕发的样子。', 'shén cǎi yì yì');
INSERT INTO `idioms` VALUES ('234', '神气活现', '神', '现', 'shén', 'xiàn', '形容自以为了不起而表现出来的得意而又傲慢的样子。 神字开头的成语 现字结尾的成语', 'shén qì huó xiàn');
INSERT INTO `idioms` VALUES ('235', '神乎其神', '神', '神', 'shén', 'shén', '神：神秘；乎：语气助词；表示感叹；其：那样。形容非常奇妙神秘。', 'shén hū qí shén');
INSERT INTO `idioms` VALUES ('236', '碧空如洗', '碧', '洗', 'bì', 'xǐ', '碧空：浅蓝色的天空。蓝色的天空明净得像洗过一样。形容天气晴朗。', 'bì kōng rú xǐ');
INSERT INTO `idioms` VALUES ('237', '碧空万里', '碧', '里', 'bì', 'lǐ', '万里：指面积大，距离长。形容天气晴朗。', 'bì kōng wàn lǐ');
INSERT INTO `idioms` VALUES ('238', '碍手碍脚', '碍', '脚', 'ài', 'jiǎo', '碍；妨碍；阻碍。指多方受阻；难以顺利做事。也指妨碍他人做事；使人感到不方便。', 'ài shǒu ài jiǎo');
INSERT INTO `idioms` VALUES ('239', '知彼知己', '知', '己', 'zhī', 'jǐ', '原意是如果对敌我双方的情况都能了解透彻，打起仗来就可以立于不败之地。泛指对双方情况都很了解。', 'zhī bǐ zhī jǐ');
INSERT INTO `idioms` VALUES ('240', '瞻前顾后', '瞻', '后', 'zhān', 'hòu', '瞻：向前望；顾：回头看。原形容做事谨慎；考虑周密。现也形容顾虑太多；犹豫不决。 瞻字开头的成语 后字结尾的成语', 'zhān qián gù hòu');
INSERT INTO `idioms` VALUES ('241', '瞠目结舌', '瞠', '舌', 'chēng', 'shé', '瞠：瞪着眼睛；结舌：翘起舌头落不下。瞪眼翘舌说不出话来；形容受窘或惊呆而一时无法对付的样子。也作“结舌瞠目”。', 'chēng mù jié shé');
INSERT INTO `idioms` VALUES ('242', '眼高手低', '眼', '低', 'yǎn', 'dī', '眼高：眼界高；手低：指办事能力低。形容要求的标准高；但实际工作能力低。', 'yǎn gāo shǒu dī');
INSERT INTO `idioms` VALUES ('243', '眼花缭乱', '眼', '乱', 'yǎn', 'luàn', '缭乱：纷乱。眼睛看见复杂纷繁的事物而发花、迷乱。', 'yǎn huā liáo luàn');
INSERT INTO `idioms` VALUES ('244', '眼疾手快', '眼', '快', 'yǎn', 'kuài', '形容做事机警敏捷。', 'yǎn jí shǒu kuài');
INSERT INTO `idioms` VALUES ('245', '真才实学', '真', '学', 'zhēn', 'xué', '真正的才华和学识。实：真。', 'zhēn cái shí xué');
INSERT INTO `idioms` VALUES ('246', '真心诚意', '真', '意', 'zhēn', 'yì', '心意真实诚恳，没有虚假。', 'zhēn xīn chéng yì');
INSERT INTO `idioms` VALUES ('247', '眉飞色舞', '眉', '舞', 'méi', 'wǔ', '色：脸色；表情。双眉挑动；兴奋愉快的表情跃然脸上。形容非常兴奋得意的样子。 眉字开头的成语 舞字结尾的成语', 'méi fēi sè wǔ');
INSERT INTO `idioms` VALUES ('248', '眉清目秀', '眉', '秀', 'méi', 'xiù', '眉、目：泛指容貌；清、秀：秀丽而不俗气。形容容貌清俊秀丽。', 'méi qīng mù xiù');
INSERT INTO `idioms` VALUES ('249', '眉开眼笑', '眉', '笑', 'méi', 'xiào', '眉头舒展；眼含笑意。形容十分高兴的样子。', 'méi kāi yǎn xiào');
INSERT INTO `idioms` VALUES ('250', '直言不讳', '直', '讳', 'zhí', 'huì', '直率地讲话；毫不隐讳（讳：忌讳；隐讳）。', 'zhí yán bù huì');
INSERT INTO `idioms` VALUES ('251', '盲人瞎马', '盲', '马', 'máng', 'mǎ', '失明的人骑着瞎了眼的马。比喻处于极端危险的境况中。也比喻乱闯瞎撞；非常危险。', 'máng rén xiā mǎ');
INSERT INTO `idioms` VALUES ('252', '盲人摸象', '盲', '象', 'máng', 'xiàng', '佛经故事；传说几个盲人各自抚摸大象的身体；每个人都以为自己所摸到的一部分就是大象；因此各人所说不一；争论不休。比喻以一点代替全面；看问题片面。', 'máng rén mō xiàng');
INSERT INTO `idioms` VALUES ('253', '目送手挥', '目', '挥', 'mù', 'huī', '手眼并用，怎么想就怎么用。也比喻语言文字的意义双关，意在言外。 目字开头的成语 挥字结尾的成语', 'mù sòng shǒu huī');
INSERT INTO `idioms` VALUES ('254', '目空一切', '目', '切', 'mù', 'qiè', '空：什么也没有。什么都不放在眼里。形容骄傲自大；什么都看不起。', 'mù kōng yī qiè');
INSERT INTO `idioms` VALUES ('255', '目瞪口呆', '目', '呆', 'mù', 'dāi', '瞪：睁大眼睛直视；呆：发愣。眼睛大睁；眼珠发直；张嘴说不出话来。形容因恐惧而失神发愣的样子。', 'mù dèng kǒu dāi');
INSERT INTO `idioms` VALUES ('256', '目中无人', '目', '人', 'mù', 'rén', '眼里没有别人。形容骄傲自大，看不起人。', 'mù zhōng wú rén');
INSERT INTO `idioms` VALUES ('257', '目不转睛', '目', '睛', 'mù', 'jīng', '睛：眼珠。眼睛不眨；眼珠不转地盯着看。形容注意力高度集中；看得出神。', 'mù bù zhuǎn jīng');
INSERT INTO `idioms` VALUES ('258', '目不暇接', '目', '接', 'mù', 'jiē', '暇：闲暇；接：接收。可看的东西太多；眼睛都忙得看不过来了。', 'mù bù xiá jiē');
INSERT INTO `idioms` VALUES ('259', '百里挑一', '百', '一', 'bǎi', 'yī', '在一百个里挑选出一个。形容相貌或才能特别突出。 百字开头的成语 一字结尾的成语', 'bǎi lǐ tiāo yī');
INSERT INTO `idioms` VALUES ('260', '百花争艳', '百', '艳', 'bǎi', 'yàn', '各种花草树木竞相开放出艳丽的花朵。', 'bǎi huā zhēng yàn');
INSERT INTO `idioms` VALUES ('261', '百炼成钢', '百', '钢', 'bǎi', 'gāng', '炼：冶炼。铁经过反复锤炼便成为坚韧的钢。比喻经过长期的、多次的锻炼；使人非常坚强。', 'bǎi liàn chéng gāng');
INSERT INTO `idioms` VALUES ('262', '百步穿杨', '百', '杨', 'bǎi', 'chuānyáng', '百步：一百步以外；杨：指杨树的叶子。在百步之外射穿一片选定的杨树叶子。形容射箭技巧娴熟。', 'bǎi bù chuānyáng');
INSERT INTO `idioms` VALUES ('263', '百战百胜', '百', '胜', 'bǎi', 'shèng', '打一百次仗；胜一百次。形容善于作战；所向无敌。', 'bǎi zhàn bǎi shèng');
INSERT INTO `idioms` VALUES ('264', '百孔千疮', '百', '疮', 'bǎi', 'chuāng', '百；千：形容数量多；孔：小洞；窟窿。形容某种事物被破坏的程度非常严重；或形容毛病、弊病很多；也作“千疮百孔”。', 'bǎi kǒng qiān chuāng');
INSERT INTO `idioms` VALUES ('265', '百发百中', '百', '中', 'bǎi', 'zhòng', '百：形容多；发：发射；也指射箭；中：正对上；恰恰合上。①指射箭技术高明；每次都能命中目标。②比喻料事准确；算计高明或做事有充分把握；绝不落空。  中字结尾的成语', 'bǎi fā bǎi zhòng');
INSERT INTO `idioms` VALUES ('266', '百依百顺', '百', '顺', 'bǎi', '', '依：依从；顺：顺从。事事都依从别人。形容一味顺从而不问是非。', 'bǎi yī bǎi shùn ');
INSERT INTO `idioms` VALUES ('267', '白雪皑皑', '白', '皑', 'bái', 'ái', '皑皑：洁白的样子，多用来形容霜雪。洁白的积雪银光耀眼。', 'bái xuě ái ái');
INSERT INTO `idioms` VALUES ('268', '白日做梦', '白', '梦', 'bái', 'mèng', '大白天做起梦来。比喻脱离实际的幻想；不可能实现的事情。', 'bái rì zuò mèng');
INSERT INTO `idioms` VALUES ('269', '白云苍狗', '白', '狗', 'bái', 'gǒu', '苍狗：黑狗。天上的白云顷刻间变成乌云；像黑狗一样。比喻世事变幻无常。', 'bái yún cāng gǒu');
INSERT INTO `idioms` VALUES ('270', '瘦骨嶙峋', '瘦', '峋', 'shòu', 'xún', '形容人或动物消瘦露骨。', 'shòu gǔ lín xún');
INSERT INTO `idioms` VALUES ('271', '痴心妄想', '痴', '想', 'chī', 'xiǎng', '痴：呆；傻；痴心：心思沉迷于某人或某种事物；妄：荒唐；胡乱；不切实际。失去理智的心思；想法荒唐。指一心想着根本无法实现的事情。 痴字开头的成语 想字结尾的成语', 'chī xīn wàng xiǎng');
INSERT INTO `idioms` VALUES ('272', '痛定思痛', '痛', '痛', 'tòng', 'tòng', '悲痛的心情平静下来以后；回想遭受痛苦的情景；让人震撼；也让人警醒。形容所受痛苦的沉重；含有警醒的意思。痛：悲痛；哀苦；定：平静。', 'tòng dìng sī tòng');
INSERT INTO `idioms` VALUES ('273', '疑神疑鬼', '疑', '鬼', 'yí', 'guǐ', '形容神经过敏；总是没有根据地胡乱猜疑。', 'yí shén yí guǐ');
INSERT INTO `idioms` VALUES ('274', '畏首畏尾', '畏', '尾', 'wèn', 'mǎ', '比喻从旁推究，弄清楚事情真相。', 'wèn niú zhī mǎ');
INSERT INTO `idioms` VALUES ('275', '畅通无阻', '畅', '阻', 'chàng', 'zǔ', '畅：不停滞；畅利地。毫无阻碍地通行或通运。多指事情能顺利地进行。', 'chàng tōng wú zǔ');
INSERT INTO `idioms` VALUES ('276', '画龙点睛', '画', '睛', 'huà', 'jīng', '画龙之后再点上眼睛。比喻在关键地方简明扼要地点明要旨；使内容生动传神。也比喻在整体中突出重点。', 'huà lóng diǎn jīng');
INSERT INTO `idioms` VALUES ('277', '画饼充饥', '画', '饥', 'huà', 'jī', '画个饼子以解饥饿。比喻徒有虚名而无实惠。也比喻借空想安慰自己。 画字开头的成语 饥字结尾的成语', 'huà bǐng chōng jī');
INSERT INTO `idioms` VALUES ('278', '画蛇添足', '画', '足', 'huà', 'zú', '画蛇时添上脚。喻指徒劳无益；多此一举。', 'huà shé tiān zú');
INSERT INTO `idioms` VALUES ('279', '电光石火', '电', '火', 'diàn', 'huǒ', '像闪电的光；燧石的火那样一闪即过。比喻事物很快消失。也形容速度极快。', 'diàn guāng shí huǒ');
INSERT INTO `idioms` VALUES ('280', '生龙活虎', '生', '虎', 'shēng', 'hǔ', '比喻像很有生气的蛟龙和富有活力的猛虎。形容活泼矫健；富有生气。', 'shēng lóng huó hǔ');
INSERT INTO `idioms` VALUES ('281', '生离死别', '生', '别', 'shēng', 'bié', '活人之间的分离就像与死者永别一样。形容很难再见面或永远分别。', 'shēng lí sǐ bié');
INSERT INTO `idioms` VALUES ('282', '生气勃勃', '生', '勃', 'shēng', 'bó', '生气：朝气；勃勃：旺盛的样子。形容富有朝气充满生命的活力。', 'shēng qì bó bó');
INSERT INTO `idioms` VALUES ('283', '生机勃勃', '生', '勃', 'shēng', 'bó', '生机：生命力。勃勃：旺盛的样子。形容有旺盛的生命力。 生字开头的成语 勃字结尾的成语', 'shēng jī bó bó');
INSERT INTO `idioms` VALUES ('284', '甜言蜜语', '甜', '语', 'tián', 'yǔ', '说的话像蜜糖一样甜。比喻动听而骗人的话。', 'tián yán mì yǔ');
INSERT INTO `idioms` VALUES ('285', '瓮中捉鳖', '瓮', '鳖', 'wèng', 'biē', '从大坛子里捉王八。比喻想要捕捉的对象已在掌握之中。形容手到擒来；轻易而有把握。', 'wèng zhōng zhuō biē');
INSERT INTO `idioms` VALUES ('286', '瓢泼大雨', '瓢', '雨', 'piáo', 'yǔ', '瓢：剖开葫芦做成的舀水器。像用瓢泼水那样的大雨。形容雨非常大。', 'piáo pō dà yǔ');
INSERT INTO `idioms` VALUES ('287', '琳琅满目', '琳', '目', 'lín', 'mù', '琳琅：美玉。满眼都是美好而珍贵的东西。比喻精美、珍贵的物品很多。', 'lín láng mǎn mù');
INSERT INTO `idioms` VALUES ('288', '理直气壮', '理', '壮', 'lǐ', 'fǔ', '班：鲁班；即公输子；春秋时鲁国人。我国著名的木匠；在鲁班门前舞弄斧头。比喻在行家面前卖弄本领。 班字开头的成语 斧字结尾的成语', 'lǐ zhí qì zhuàng 直：正确：bān mén nòng fǔ');
INSERT INTO `idioms` VALUES ('289', '狼吞虎咽', '狼', '咽', 'láng', 'yàn', '像狼虎一样吞咽东西。形容吃东西又猛又急的样子。', 'láng tūn hǔ yàn');
INSERT INTO `idioms` VALUES ('290', '独树一帜', '独', '帜', 'dú', 'zhì', '单独打起一面旗号。比喻风格新奇；自成一家。也比喻自立门户。', 'dú shù yī zhì');
INSERT INTO `idioms` VALUES ('291', '独占鳌头', '独', '头', 'dú', 'tóu', '鳌：传说中的大海龟、海鳖。旧时皇宫的殿门前台阶中间刻有飞龙及巨鳌的浮雕；皇帝在殿前召见新考中的状元、榜眼等人。状元跪在前面；正好是飞龙巨鳌浮雕的头部。原指科举考试中了状元。现泛指占首位或第一名。', 'dú zhàn áo tóu');
INSERT INTO `idioms` VALUES ('292', '独具匠心', '独', '心', 'dú', 'xīn', '匠心：巧妙的心思。具有独特的巧妙心思。多指技术或艺术方面有创造性。', 'dú jù jiàng xīn');
INSERT INTO `idioms` VALUES ('293', '狗屁不通', '狗', '通', 'gǒu', 'tōng', '不通 拼音：gǒu pì bù tōng释义指责别人说话或文章极不通顺', 'gǒu pì bù tōng');
INSERT INTO `idioms` VALUES ('294', '狗头军师', '狗', '师', 'gǒu', 'shī', '比喻爱给人出主意而主意又不高明的人。也比喻专门出坏主意的人。 狗字开头的成语 师字结尾的成语', 'gǒu tóu jūn shī');
INSERT INTO `idioms` VALUES ('295', '狐群狗党', '狐', '党', 'hú', 'dǎng', '与狐；狗结群为党。比喻勾结在一起的坏人。', 'hú qún gǒu dǎng');
INSERT INTO `idioms` VALUES ('296', '狐假虎威', '狐', '威', 'jiǎ', 'wēi', '假：假借；凭借。狐狸借着老虎的威风去吓唬其他野兽。比喻凭借别人的威势来欺压人。', 'jiǎ hǔ wēi');
INSERT INTO `idioms` VALUES ('297', '狂风暴雨', '狂', '雨', 'kuáng', 'yǔ', '大风大雨。比喻声势猛烈或处境险恶。', 'kuáng fēng bào yǔ');
INSERT INTO `idioms` VALUES ('298', '牛毛细雨', '牛', '雨', 'niú', 'yǔ', '指极细的小雨。', 'niú máo xì yǔ');
INSERT INTO `idioms` VALUES ('299', '爱财如命', '爱', '命', 'ài', 'mìng', '爱：吝惜；舍不得。吝惜钱财如同吝惜自己的生命一样。形容对钱财的贪婪、吝啬达到了无以复加的程度。', 'ài cái rú mìng');
INSERT INTO `idioms` VALUES ('300', '爱屋及乌', '爱', '乌', 'ài', 'wū', '乌；乌鸦。喜爱那所房屋；连房屋上的乌鸦也一并喜爱。比喻由于喜爱某人也连带地喜爱与他有关系的人或物。 爱字开头的成语 乌字结尾的成语', 'ài wū jí wū');
INSERT INTO `idioms` VALUES ('301', '爱不释手', '爱', '手', 'ài', 'shǒu', '释：放开。喜爱到不肯放手。', 'ài bù shì shǒu');
INSERT INTO `idioms` VALUES ('302', '燃眉之急', '燃', '急', 'rán', 'jí', '燃眉：火烧眉毛。火烧眉毛那样地紧急。比喻事情非常急迫。', 'rán méi zhī jí');
INSERT INTO `idioms` VALUES ('303', '熙熙攘攘', '熙', '攘', 'xī', 'rǎng', '熙熙：和乐的样子；攘攘：纷乱的样子。形容人来人往；非常热闹。', 'xī xī rǎng rǎng');
INSERT INTO `idioms` VALUES ('304', '熙来攘往', '熙', '往', 'xī', 'wǎng', '熙、攘：喧闹、纷乱的样子。人来人往；喧闹纷杂。', 'xī lái rǎng wǎng');
INSERT INTO `idioms` VALUES ('305', '焦头烂额', '焦', '额', 'jiāo', 'é', '头部和额部被烧焦、灼烂。比喻受到严重打击而惨败。也形容忙得不知如何是好；非常狼狈窘迫。', 'jiāo tóu làn é');
INSERT INTO `idioms` VALUES ('306', '焕然一新', '焕', '新', 'huàn', 'xīn', '焕然：形容有光彩。光彩夺目；给人一种全新的感觉。形容出现了崭新的面貌；显得很光彩。 焕字开头的成语 新字结尾的成语', 'huàn rán yī xīn');
INSERT INTO `idioms` VALUES ('307', '热情洋溢', '热', '溢', 'rè', 'yì', '热烈的感情充分地流露出来。', 'rè qíng yáng yì');
INSERT INTO `idioms` VALUES ('308', '烟消云散', '烟', '散', 'yān', 'sàn', '消：消失；散：散去。像烟雾和云气一样消散。比喻消失得无影无踪。也作“云消雾散”。', 'yān xiāo yún sàn');
INSERT INTO `idioms` VALUES ('309', '烘云托月', '烘', '月', 'hōng', 'yuè', '烘；渲染；托：衬托　。原指作画时渲染云彩来衬托月亮。比喻不从正面描绘；而从侧面点染以烘托突出主要事物。', 'hōng yún tuō yuè');
INSERT INTO `idioms` VALUES ('310', '炯炯有神', '炯', '神', 'jiǒng', 'shén；', '炯炯：明亮的样子。形容眼睛明亮有神。', 'jiǒng jiǒng yǒu shén；');
INSERT INTO `idioms` VALUES ('311', '灯红酒绿', '灯', '绿', 'dēng', 'lǜ', '灯光与酒色；红绿相映。形容娇奢淫逸的生活；也形容娱乐场所的繁华景象。也作“酒绿灯红”。', 'dēng hóng jiǔ lǜ');
INSERT INTO `idioms` VALUES ('312', '火烧眉毛', '火', '毛', 'huǒ', 'mɑo', '火烧到眉毛了。比喻情势非常紧迫。也作“火烧眉睫”。 火字开头的成语 毛字结尾的成语', 'huǒ shāo méi mɑo');
INSERT INTO `idioms` VALUES ('313', '火树银花', '火', '花', 'huǒ', 'huā', '火树：火红的树；指树上挂满灯彩；银花：银白色的花。指灯光闪亮；绚丽灿烂。', 'huǒ shù yín huā');
INSERT INTO `idioms` VALUES ('314', '漫山遍野', '漫', '野', 'màn', 'yě', '漫：原为水满外流的意思；引申为“布满”；遍：动词；遍及；布满。原指布满了山坡山冈、田间旷野。形容数量很多、范围很广、声势很大。', 'màn shān biàn yě');
INSERT INTO `idioms` VALUES ('315', '漫不经心', '漫', '心', 'màn', 'xīn', '漫：随便；不受约束；经心：在意；留心。说话办事不用心考虑；随随便便；不在乎。', 'màn bù jīng xīn');
INSERT INTO `idioms` VALUES ('316', '滴水成冰', '滴', '冰', 'dī', 'bīng', '水滴下去就结成冰。形容天气非常寒冷。', 'dī shuǐ chéng bīng');
INSERT INTO `idioms` VALUES ('317', '滴水不漏', '滴', '漏', 'dī', 'lòu', '一滴水也都漏不出去。比喻说话做事非常周全、严密；没有丝毫漏失；使人无隙可乘。', 'dī shuǐ bù lòu');
INSERT INTO `idioms` VALUES ('318', '满天星斗', '满', '斗', 'mǎn', 'dǒu', '星斗：星的总称。布满天空的星星。比喻事情多而杂乱。后形容文章华美。 满字开头的成语 斗字结尾的成语', 'mǎn tiān xīng dǒu');
INSERT INTO `idioms` VALUES ('319', '满城风雨', '满', '雨', 'mǎn', 'yǚ', '满城：指全城各处。城里到处刮风下雨。原形容秋天景色。后形容事情传遍各处；到处都在议论着。', 'mǎn chéng fēng yǚ');
INSERT INTO `idioms` VALUES ('320', '滔滔不绝', '滔', '绝', 'tāo', 'jué', '滔滔：水流滚滚；连续不断的样子。像水流一样不间断。比喻话多而又流畅。', 'tāo tāo bù jué');
INSERT INTO `idioms` VALUES ('321', '滂沱大雨', '滂', '雨', 'páng', 'yǔ', '滂沱：大雨的样子。形容雨下得很大。', 'páng tuó dà yǔ');
INSERT INTO `idioms` VALUES ('322', '湖光山色', '湖', '色', 'hú', 'sè', '湖水风光；山峦秀色。形容山水景色之美。', 'hú guāng shān sè');
INSERT INTO `idioms` VALUES ('323', '清清楚楚', '清', '楚', 'qīng', 'chǔ', '清晰明白有条理', 'qīng qīng chǔ chǔ');
INSERT INTO `idioms` VALUES ('324', '深更半夜', '深', '夜', 'shēn', 'yè', '深夜。 深字开头的成语 夜字结尾的成语', 'shēn gēng bàn yè');
INSERT INTO `idioms` VALUES ('325', '深思熟虑', '深', '虑', 'shēn', 'lǜ', '熟：细致。反复细致地思索考虑。', 'shēn sī shú lǜ');
INSERT INTO `idioms` VALUES ('326', '深入浅出', '深', '出', 'shēn', 'chū', '指讲话或文章的内容深刻；语言文字却浅显易懂。', 'shēn rù qiǎn chū');
INSERT INTO `idioms` VALUES ('327', '海誓山盟', '海', '盟', 'hǎi', 'méng', '指着山、海发誓；订立盟约。表示要象高山大海一样永恒不变。多指男女相爱相许时的誓约。誓：誓言；盟：盟约。也作“山盟海誓”。', 'hǎi shì shān méng');
INSERT INTO `idioms` VALUES ('328', '浮想联翩', '浮', '翩', 'fú', 'piān', '浮想：漂浮变幻的想象。联翩：鸟飞的样子；比喻连续不断。漂浮不定的想象像鸟飞一样。指思绪连续不断地涌现出来。', 'fú xiǎng lián piān');
INSERT INTO `idioms` VALUES ('329', '浮云蔽日', '浮', '日', 'fú', 'rì', ' 浮云遮住太阳。原比喻奸佞之徒蒙蔽君主。后泛指小人当道，社会一片黑暗。', 'fú yún bì rì');
INSERT INTO `idioms` VALUES ('330', '浩如烟海', '浩', '海', 'hào', 'hǎi', '浩：广大；众多；烟海：茫茫大海。指广大繁多如茫茫烟海。形容书籍、资料、文献等非常丰富。 浩字开头的成语 海字结尾的成语', 'hào rú yān hǎi');
INSERT INTO `idioms` VALUES ('331', '浑然一体', '浑', '体', 'hún', 'tǐ', '浑然：完整不可分。融合成为一个难以分割的整体。', 'hún rán yī tǐ');
INSERT INTO `idioms` VALUES ('332', '流言蜚语', '流', '语', 'liú', 'yǔ', '毫无根据的话；多指背后议论、诬蔑或挑拨离间的坏话。', 'liú yán fēi yǔ');
INSERT INTO `idioms` VALUES ('333', '洪水猛兽', '洪', '兽', 'hóng', 'shòu', '洪水：能造成灾害的大水；猛兽：残酷食人畜的凶猛野兽。比喻极大的灾害。', 'hóng shuǐ měng shòu');
INSERT INTO `idioms` VALUES ('334', '津津有味', '津', '味', 'jīn', 'wèi', '津：口液；唾液；津津：兴趣浓厚的样子。形容趣味很浓或很有滋味。', 'jīn jīn yǒu wèi');
INSERT INTO `idioms` VALUES ('335', '洛阳纸贵', '洛', '贵', 'luò', 'guì', '因为抢着抄写左思的《三都赋》；以致洛阳的纸价高起来了。形容写文章、著作广泛流传；风行一时。', 'luò yáng zhǐ guì');
INSERT INTO `idioms` VALUES ('336', '洗耳恭听', '洗', '听', 'xǐ', 'tīng', '洗耳：擦洗耳朵；比喻很重视听对方说话；恭：恭敬地。洗干净耳朵恭恭敬敬听别人讲话。请人讲话时的客气话。指专心地听。 洗字开头的成语 听字结尾的成语', 'xǐ ěr gōng tīng');
INSERT INTO `idioms` VALUES ('337', '洗心革面', '洗', '面', 'xǐ', 'miàn', '洗心：消除邪恶的思想；革面：改变旧的面目。比喻彻底悔改；重新做人。', 'xǐ xīn gé miàn');
INSERT INTO `idioms` VALUES ('338', '洋洋得意', '洋', '意', 'yáng', 'yì', '形容神气十足，非常得意。', 'yáng yáng dé yì');
INSERT INTO `idioms` VALUES ('339', '洋洋大观', '洋', '观', 'yáng', 'guān', '大观 拼音：yáng yáng dà guān释义洋洋：盛大、众多的样子；大观：丰富多彩的景象。形容事物繁多；丰富多彩；气象宏大；非常可观。', 'yáng yáng dà guān');
INSERT INTO `idioms` VALUES ('340', '泰然处之', '泰', '之', 'tài', 'zhī', '形容遇事镇定自如。也指对事不放在心上；采取无所谓的态度。', 'tài rán chǔ zhī');
INSERT INTO `idioms` VALUES ('341', '泥牛入海', '泥', '海', 'ní', 'hǎi', '泥塑的牛进入大海中就会化掉。比喻一去不返；杳无音信。', 'ní niú rù hǎi');
INSERT INTO `idioms` VALUES ('342', '波澜壮阔', '波', '阔', 'bō', 'kuò', '澜：大波浪；壮阔：又雄壮又宽广。指水的波涛浩渺广阔。比喻声势雄壮有力；规模宏大。', 'bō lán zhuàng kuò');
INSERT INTO `idioms` VALUES ('343', '波涛汹涌', '波', '涌', 'bō', 'yǒng', '汹涌：水势腾涌的样子。形容波浪又大又急。 波字开头的成语 涌字结尾的成语', 'bō tāo xiōng yǒng');
INSERT INTO `idioms` VALUES ('344', '波光粼粼', '波', '粼', 'bō', 'lín', '波光：阳光或月光照在水波上反射过来的光。粼粼：形容水石明净。波光明净。', 'bō guāng lín lín');
INSERT INTO `idioms` VALUES ('345', '沧海一粟', '沧', '粟', 'cāng', 'sù', '沧海：大海；粟：谷子。大海中的一粒谷子。比喻非常渺小；微不足道。也作“大海一粟”。', 'cāng hǎi yī sù');
INSERT INTO `idioms` VALUES ('346', '没精打采', '没', '采', 'méi', 'cǎi', '精：精神；采：神色。打不起精神；提不起兴致。形容精神萎靡；不振作、不高兴。', 'méi jīng dǎ cǎi');
INSERT INTO `idioms` VALUES ('347', '沉鱼落雁', '沉', '雁', 'chén', 'yàn', '沉：使下沉；落：使落下。原指女子貌美；使游鱼下沉；使飞雁降落；不敢与之比美。后来形容女子容貌美丽动人。', 'chén yú luò yàn');
INSERT INTO `idioms` VALUES ('348', '汪洋大海', '汪', '海', 'wāng', 'hǎi', '广阔无边；水波连天的大海。比喻事物的范围广阔；声势浩大。汪洋：水势深而广阔。', 'wāng yáng dà hǎi');
INSERT INTO `idioms` VALUES ('349', '江山如画', '江', '画', 'jiāng', 'huà', '江山：山河；常指国土。山河美如图画。 江字开头的成语 画字结尾的成语', 'jiāng shān rú huà');
INSERT INTO `idioms` VALUES ('350', '求同存异', '求', '异', 'qiú', 'yì', '寻求彼此的共同处；保留彼此的分歧处。', 'qiú tóng cún yì');
INSERT INTO `idioms` VALUES ('351', '永垂不朽', '永', '朽', 'yǒng', 'xiǔ', '朽：磨灭。指光辉的事迹或伟大的精神永远流传下去；永远不会磨灭。”', 'yǒng chuí bù xiǔ');
INSERT INTO `idioms` VALUES ('352', '水滴石穿', '水', '穿', 'shuǐ', 'chuān', '滴：液体一点一点地往下落；穿：破；透。指水一滴一滴不断地往下落；把石头穿透。比喻只要有恒心；不断努力；事情自然会成功。', 'shuǐ dī shí chuān');
INSERT INTO `idioms` VALUES ('353', '水泄不通', '水', '通', 'shuǐ', 'tōng', '泄：泄漏。原意为水都流不出去。形容拥挤和包围得非常严密。', 'shuǐ xiè bù tōng');
INSERT INTO `idioms` VALUES ('354', '水乳交融', '水', '融', 'shuǐ', 'róng', '融：融洽；乳：奶汁。水和奶溶合在一起。比喻关系非常融洽或结合十分紧密或意气相投。', 'shuǐ rǔ jiāo róng');
INSERT INTO `idioms` VALUES ('355', '气味相投', '气', '投', 'qì', 'tóu', '气味：意指思想或志趣；投：合得来。指人思想作风相同；彼此很合得来。 气字开头的成语 投字结尾的成语', 'qì wèi xiāng tóu');
INSERT INTO `idioms` VALUES ('356', '气吞山河', '气', '河', '', 'hé', '气势可以吞掉高山和大河。形容气势、气魄很大。', ' qì tūn shān hé');
INSERT INTO `idioms` VALUES ('357', '气势汹汹', '气', '汹', 'qì', 'xiōng', '汹汹：声势盛大的样子。气势很盛的样子。形容气势凶猛。', 'qì shì xiōng xiōng');
INSERT INTO `idioms` VALUES ('358', '毛手毛脚', '毛', '脚', 'máo', 'jiǎo', '做事粗心，不细致。', 'máo shǒu máo jiǎo');
INSERT INTO `idioms` VALUES ('359', '比比皆是', '比', '是', 'bǐ', 'shì', '比比：一个挨一个；引申为处处；到处；皆：全部。形容某种东西到处都是；很多。', 'bǐ bǐ jiē shì');
INSERT INTO `idioms` VALUES ('360', '残兵败将', '残', '将', 'cán', 'jiàng', '残：残余的；不完整的；败：输。剩下的士兵；打败的将官。形容损失惨重；被打得七零八落；失去战斗力的军队。也作“残兵败卒”、“败将残兵”。', 'cán bīng bài jiàng');
INSERT INTO `idioms` VALUES ('361', '死气沉沉', '死', '沉', 'sǐ', 'chén', '形容没有一点生气。有时也形容意志消沉；缺少活力。 死字开头的成语 沉字结尾的成语', 'sǐ qì chén chén');
INSERT INTO `idioms` VALUES ('362', '步步为营', '步', '营', 'bù', 'yíng', '步：古时五尺为步；步步：表示距离近；营：军事营垒。军队每前进一步就设下一道营垒。比喻行动谨慎；防备严密。现常用来比喻行动、做事谨慎；稳扎稳打。', 'bù bù wéi yíng');
INSERT INTO `idioms` VALUES ('363', '此起彼伏', '此', '伏', 'cǐ', 'fú', '此：这；这个；彼：那；那个；伏：低下去。这里起来；那里下去。形容联系紧密；互相配合行动。也作“此伏彼此”、“此起彼落”。', 'cǐ qǐ bǐ fú');
INSERT INTO `idioms` VALUES ('364', '欣欣向荣', '欣', '荣', 'xīn', 'róng', '形容草木长得茂盛。比喻事业蓬勃发展；兴旺昌盛。荣：茂盛。', 'xīn xīn xiàng róng');
INSERT INTO `idioms` VALUES ('365', '欢天喜地', '欢', '地', 'huān', 'dì', '形容非常高兴、快乐。', 'huān tiān xǐ dì');
INSERT INTO `idioms` VALUES ('366', '欢呼雀跃', '欢', '跃', 'huān', 'yuè', '高兴得像麻雀一样跳跃。形容非常欢乐。', 'huān hū què yuè');
INSERT INTO `idioms` VALUES ('367', '格格不入', '格', '入', 'gé', 'rù', '形容彼此不协调；不相容。格格：阻碍；隔阂。入：融洽。', 'gé gé bù rù');
INSERT INTO `idioms` VALUES ('368', '栩栩如生', '栩', '生', 'xǔ', 'shēng', '形容形象逼真；如同活人一样。栩栩：生动活泼的样子；生：活的。', 'xǔ xǔ rú shēng');
INSERT INTO `idioms` VALUES ('369', '枯木逢春', '枯', '春', 'kū', 'chūn', '枯：枯萎；木：树木；逢：遇上。枯树遇上春天又有了生机。比喻经历挫折又获得生机。', 'kū mù féng chūn');
INSERT INTO `idioms` VALUES ('370', '枪林弹雨', '枪', '雨', 'qiāng', 'yǔ', '枪杆像树林；子弹像下雨。形容战斗激烈；炮火密集的战场。', 'qiāng lín dàn yǔ');
INSERT INTO `idioms` VALUES ('371', '枝繁叶茂', '枝', '茂', 'zhī', 'mào', '枝叶繁密茂盛。', 'zhī fán yè mào');
INSERT INTO `idioms` VALUES ('372', '林林总总', '林', '总', 'lín', 'zǒng', '林林：树木聚集成片的样子；总总：全部汇集状。形容人或事物繁多。 林字开头的成语 总字结尾的成语', 'lín lín zǒng zǒng');
INSERT INTO `idioms` VALUES ('373', '杯水车薪', '杯', '薪', 'bēi', 'xīn', '杯水：一杯水；车薪：一车柴草。一杯水救不了一大车着了火的柴草。比喻力量太小；对解决困难作用不大。', 'bēi shuǐ chē xīn');
INSERT INTO `idioms` VALUES ('374', '杯弓蛇影', '杯', '影', 'bēi', 'yǐng', '①将映在杯中的弓影误认为蛇。比喻疑神疑鬼；自相惊扰。②也可用来比喻虚幻的实际不存在的东西。也作“弓影杯蛇”。', 'bēi gōng shé yǐng');
INSERT INTO `idioms` VALUES ('375', '来日方长', '来', '长', 'lái', 'cháng', '来日：未来的日子。方：正。将来的日子还长着呢。表示事有可为。', 'lái rì fāng cháng');
INSERT INTO `idioms` VALUES ('376', '杞人忧天', '杞', '天', 'qǐ', 'tiān', '杞：古时国名；忧天：担心天塌陷。杞国人担心天会塌下来；寝食不安。比喻不必要的或毫无根据的忧虑。', 'qǐ rén yōu tiān');
INSERT INTO `idioms` VALUES ('377', '杂乱无章', '杂', '章', 'zá', 'zhāng', '杂乱：多而乱；无章：没有条理。混乱而没有条理。', 'zá luàn wú zhāng');
INSERT INTO `idioms` VALUES ('378', '杀鸡儆猴', '杀', '猴', 'shā', 'hóu', '杀鸡给猴子看。比喻用惩罚一个人的办法来警告别的人。 杀字开头的成语 猴字结尾的成语', 'shā jī jǐng hóu');
INSERT INTO `idioms` VALUES ('379', '杀一儆百', '杀', '百', 'shā', 'bǎi', '儆：警戒。处死一个人；借以警戒许多人。', 'shā yī jǐng bǎi');
INSERT INTO `idioms` VALUES ('380', '未雨绸缪', '未', '缪', 'wèi', 'móu', '绸缪：修缮房屋。在没有下雨前；就要修缮好门窗。比喻事先作好准备；防患未然。', 'wèi yǔ chóu móu');
INSERT INTO `idioms` VALUES ('381', '朝思暮想', '朝', '想', 'zhāo', 'xiǎng', '从早到晚思念不已。形容思念之深切。多用于男女恋情。', 'zhāo sī mù xiǎng');
INSERT INTO `idioms` VALUES ('382', '朝夕相处', '朝', '处', 'zhāo', 'chǔ', '从早到晚都在一起。形容常生活在一起，关系密切。', 'zhāo xī xiāng chǔ');
INSERT INTO `idioms` VALUES ('383', '朝云暮雨', '朝', '雨', 'zhāo', 'yǔ', '暮：傍晚。早上是云，晚上是雨。原指神女的早晚变化，旧时用以喻指男女的欢会。', 'zhāo yún mù yǔ');
INSERT INTO `idioms` VALUES ('384', '望而生畏', '望', '畏', 'wàng', 'wèi', '看着就害怕。生畏：害怕。 望字开头的成语 畏字结尾的成语', 'wàng ér shēng wèi');
INSERT INTO `idioms` VALUES ('385', '有眼无珠', '有', '珠', 'yǒu', 'zhū', '珠：眼珠。长着眼睛没有眼珠。比喻没有识别人或事物的能力。', 'yǒu yǎn wú zhū');
INSERT INTO `idioms` VALUES ('386', '有机可乘', '有', '乘', 'yǒu', 'chéng', '机：机会；乘：趁。有空子可钻。指客观上提供了可以用来达到某种目的的机会。', 'yǒu jī kě chéng');
INSERT INTO `idioms` VALUES ('387', '有头无尾', '有', '尾', 'yǒu', 'wěi', '只有开头；没有结尾。指说话做事不完整。', 'yǒu tóu wú wěi');
INSERT INTO `idioms` VALUES ('388', '有名无实', '有', '实', 'yǒu', 'shí', '光有虚名；并无事实。指实际上并不是那么好。', 'yǒu míng wú shí');
INSERT INTO `idioms` VALUES ('389', '有口无心', '有', '心', 'yǒu', 'xīn', '嘴里有啥说啥；心里却没有什么。', 'yǒu kǒu wú xīn');
INSERT INTO `idioms` VALUES ('390', '月明星稀', '月', '稀', 'yuè', 'xī', '月亮光明亮时；星星就显得稀疏了。', 'yuè míng xīng xī');
INSERT INTO `idioms` VALUES ('391', '月中折桂', '月', '桂', 'yuè', 'guì', '在月亮中折桂树枝。比喻科举及第。 月字开头的成语 桂字结尾的成语', 'yuè zhōng shé guì');
INSERT INTO `idioms` VALUES ('392', '暴跳如雷', '暴', '雷', 'bào', 'léi', '暴：急躁；发怒。蹦跳发怒；好像打雷一样猛烈。', 'bào tiào rú léi');
INSERT INTO `idioms` VALUES ('393', '晴天霹雳', '晴', '雳', 'qíng', 'lì', '雳：炸雷。晴天打响雷；比喻突发性的令人吃惊的事情或灾祸。', 'qíng tiān pī lì');
INSERT INTO `idioms` VALUES ('394', '普天同庆', '普', '庆', 'pǔ', 'qìng', '普：普遍；天：天下；庆：庆贺。普天下共同庆祝。', 'pǔ tiān tóng qìng');
INSERT INTO `idioms` VALUES ('395', '昭然若揭', '昭', '揭', 'zhāo', 'jiē', '昭然：明明白白的样子；揭：高举。形容真相大白；非常明显。', 'zhāo rán ruò jiē');
INSERT INTO `idioms` VALUES ('396', '春风化雨', '春', '雨', 'chūn', 'yǔ', '化雨：适时的雨。像用和暖的春风吹拂人；似及时的雨水滋润大地一样。比喻良好教育的普遍深入。也用来称颂师长的教诲。', 'chūn fēng huà yǔ');
INSERT INTO `idioms` VALUES ('397', '春雨如油', '春', '油', 'chūn', 'yóu', '春雨贵如油。形容春雨可贵。 春字开头的成语 油字结尾的成语', 'chūn yǔ rú yóu');
INSERT INTO `idioms` VALUES ('398', '春花秋月', '春', '月', 'chūn', 'yuè', '春天的花朵，秋天的月亮。泛指春秋美景。', 'chūn huā qiū yuè');
INSERT INTO `idioms` VALUES ('399', '春暖花开', '春', '开', 'chūn', 'kāi', '春天气候温暖；百花盛开。形容美丽的景色。比喻事物得以顺利发展的良好环境或机遇。', 'chūn nuǎn huā kāi');
INSERT INTO `idioms` VALUES ('400', '春意盎然', '春', '然', 'chūn', 'rán', '意：意味；盎然：洋溢；深厚。春天的意味正浓。', 'chūn yì àng rán');
INSERT INTO `idioms` VALUES ('401', '春回大地', '春', '地', 'chūn', 'dì', '好象春天又回到大地。形容严寒已过，温暖和生机又来到人间。', 'chūn huí dà dì');
INSERT INTO `idioms` VALUES ('402', '春光明媚', '春', '媚', 'chūn', 'mèi', '明媚：鲜艳可爱；形容春天的景物十分美好。', 'chūn guāng míng mèi');
INSERT INTO `idioms` VALUES ('403', '星罗棋布', '星', '布', 'xīng', 'bù', '像天空的星星和棋盘上的棋子那样分布着。形容数量很多；分布很广。罗：罗列；布：分布。 星字开头的成语 布字结尾的成语', 'xīng luó qí bù');
INSERT INTO `idioms` VALUES ('404', '明眸皓齿', '明', '齿', 'míng', 'chǐ', '眸：眸子；眼珠；皓：洁白。明亮的眼睛；洁白的牙齿。形容女子的美貌；也借指美女。', 'míng móu hào chǐ');
INSERT INTO `idioms` VALUES ('405', '明枪暗箭', '明', '箭', 'míng', 'jiàn', '比喻种种公开和隐蔽的攻击、伤害。', 'míng qiāng àn jiàn');
INSERT INTO `idioms` VALUES ('406', '明日黄花', '明', '花', 'míng', 'huā', '黄花：菊花。原指重阳节过后逐渐萎谢的菊花。后多比喻过时的事物或消息。', 'míng rì huáng huā');
INSERT INTO `idioms` VALUES ('407', '明察暗访', '明', '访', 'míng', 'fǎng', '察：调查研究；访：查询。公开察看了解；暗中调查访问。指用不同方式；从不同方面进行调查了解。', 'míng chá àn fǎng');
INSERT INTO `idioms` VALUES ('408', '明争暗斗', '明', '斗', 'míng', 'dòu', '表面上和暗地里都在进行争斗；形容内部钩心斗争；互相争斗的情况。', 'míng zhēng àn dòu');
INSERT INTO `idioms` VALUES ('409', '昂首挺胸', '昂', '胸', 'áng', 'xiōng', '昂：仰；抬起；挺胸：挺起胸膛。仰着头；挺起胸膛。形容精神饱满的样子。 昂字开头的成语 胸字结尾的成语', 'áng shǒu tǐng xiōng');
INSERT INTO `idioms` VALUES ('410', '旭日东升', '旭', '升', 'xù', 'shēng', '早晨太阳从东方升起。形容朝气蓬勃的气象。旭日：早晨刚出来的太阳。', 'xù rì dōng shēng');
INSERT INTO `idioms` VALUES ('411', '日薄西山', '日', '山', 'rì', 'shān', '薄：迫近；西山：泛指西边的高山。太阳快落山了。比喻人已经衰老或事物衰败腐朽；临近死亡。', 'rì bó xī shān');
INSERT INTO `idioms` VALUES ('412', '日落西山', '日', '山', 'rì', 'shān', '太阳迫近西山；快要落下。也比喻人到老年将死或事物接近衰亡。', 'rì luò xī shān');
INSERT INTO `idioms` VALUES ('413', '日积月累', '日', '累', 'rì', 'lěi', '一天一天、一月一月地不断积累。指长时间不断地积累。', 'rì jī yuè lěi');
INSERT INTO `idioms` VALUES ('414', '日新月异', '日', '异', 'rì', 'yì', '新：更新；异：不同。指发展或进步迅速；不断出现新事物、新气象。', 'rì xīn yuè yì');
INSERT INTO `idioms` VALUES ('415', '日久天长', '日', '长', 'rì', 'cháng', '指时间很久远。日：指时间。 日字开头的成语 长字结尾的成语', 'rì jiǔ tiān cháng');
INSERT INTO `idioms` VALUES ('416', '日上三竿', '日', '竿', 'rì', 'gān', '太阳升起有三根竹竿那样高。形容太阳升得很高，时间不早了。也形容人起床太晚。', 'rì shàng sān gān');
INSERT INTO `idioms` VALUES ('417', '无边无际', '无', '际', 'wú', 'jì', '际：边缘处。形容范围极为广阔。', 'wú biān wú jì');
INSERT INTO `idioms` VALUES ('418', '无穷无尽', '无', '尽', 'wú', 'jìn', '穷、尽：完。没有尽头；没有限度。', 'wú qióng wú jìn');
INSERT INTO `idioms` VALUES ('419', '无所顾忌', '无', '忌', 'wǔ', 'jì', '顾忌：因有顾虑而不敢说或做。没有什么顾虑。', 'wǔ suǒ gù jì');
INSERT INTO `idioms` VALUES ('420', '无所不包', '无', '包', 'wú', 'bāo', '包：包容。没有什么不被包括。形容包含的东西非常多。', 'wú suǒ bù bāo');
INSERT INTO `idioms` VALUES ('421', '无忧无虑', '无', '虑', 'wú', 'lǜ', '无：没有。没有任何忧虑。形容心情舒畅自然。 无字开头的成语 虑字结尾的成语', 'wú yōu wú lǜ');
INSERT INTO `idioms` VALUES ('422', '无影无踪', '无', '踪', 'wú', 'zōng', '踪：踪迹。形容完全消失；不知去向。', 'wú yǐng wú zōng');
INSERT INTO `idioms` VALUES ('423', '无孔不入', '无', '入', 'wú', 'rù', '孔：小洞。有空子就钻。比喻利用一切机会去活动。', 'wú kǒng bù rù');
INSERT INTO `idioms` VALUES ('424', '无奇不有', '无', '有', 'wú', 'yǒu', '什么稀奇古怪的事物都有。', 'wú qí bù yǒu');
INSERT INTO `idioms` VALUES ('425', '无可救药', '无', '药', 'wú', 'yào', '比喻坏到了无法挽救的地步。', 'wú kě jiù yào');
INSERT INTO `idioms` VALUES ('426', '无中生有', '无', '有', 'wú', 'yǒu', '把没有的说成有。指凭空捏造。  有字结尾的成语', 'wú zhōng shēng yǒu');
INSERT INTO `idioms` VALUES ('427', '旁敲侧击', '旁', '击', 'páng', 'jī', '侧：旁边；击：敲打。在旁边敲打。比喻说话作文隐晦曲折；不直接把意思表达出来。', 'páng qiāo cè jī');
INSERT INTO `idioms` VALUES ('428', '斤斤计较', '斤', '较', 'jīn', 'jiào', '斤斤：明察细微；引申为琐细。计较细小的事物。现比喻过分计较无关紧要的或琐细的小事。', 'jīn jīn jì jiào');
INSERT INTO `idioms` VALUES ('429', '斜风细雨', '斜', '雨', 'xié', 'yǔ', '形容小的风雨。斜风：旁侧吹来的小风；细雨：小雨。', 'xié fēng xì yǔ');
INSERT INTO `idioms` VALUES ('430', '料事如神', '料', '神', 'liào', 'shén', '料事：揣度事情的发展和结局。如神：形容极其奇妙灵验或预料事情非常准确。预料事情就如同神一样。形容对事情的预料和事情发生的完全一样。', 'liào shì rú shén');
INSERT INTO `idioms` VALUES ('431', '斗志昂扬', '斗', '扬', 'dòu', 'yáng', '斗：泛指做事；昂扬：情绪高涨。形容做事的热情很高。', 'dòu zhì áng yáng');
INSERT INTO `idioms` VALUES ('432', '斐然成章', '斐', '章', 'fěi', 'zhāng', '非常有文采；出口便成章。斐然：有文采的样子。也用以形容才干或声名显耀。 斐字开头的成语 章字结尾的成语', 'fěi rán chéng zhāng');
INSERT INTO `idioms` VALUES ('433', '文质彬彬', '文', '彬', 'wén', 'bīn', '原义为人的文采和本质都很适宜。后形容言谈举止斯文闲雅。彬彬：配合谐调。', 'wén zhì bīn bīn');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `levelName` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', '小学 一年级 上册', 'classoneup.jpg');
INSERT INTO `level` VALUES ('2', '小学 一年级 下册', 'classOneDown.jpg');
INSERT INTO `level` VALUES ('3', '小学 二年级 上册', 'classTwoOn.jpg');
INSERT INTO `level` VALUES ('4', '小学 二年级 下册', 'classTwoDown.jpg');
INSERT INTO `level` VALUES ('5', '小学 三年级 上册', 'classThreeOn.jpg');
INSERT INTO `level` VALUES ('6', '小学 三年级 下册', 'classThreeDown.jpg');
INSERT INTO `level` VALUES ('7', '小学 四年级 上册', 'classFourOn.jpg');
INSERT INTO `level` VALUES ('8', '小学 四年级 下册', 'classFourDown.jpg');
INSERT INTO `level` VALUES ('9', '小学 五年级 上册', 'classFIveOn.jpg');
INSERT INTO `level` VALUES ('10', '小学 五年级 下册', 'classFiveDown.jpg');
INSERT INTO `level` VALUES ('11', '小学 六年级 上册', 'classSixOn.jpg');
INSERT INTO `level` VALUES ('12', '小学 六年级 下册', 'classSixDown.jpg');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `studiedTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '2020-04-23 11:13:22');
INSERT INTO `record` VALUES ('2', '1', '2020-04-23 12:43:13');
INSERT INTO `record` VALUES ('3', '1', '2020-04-23 12:54:15');
INSERT INTO `record` VALUES ('4', '1', '2020-04-23 12:55:25');
INSERT INTO `record` VALUES ('5', '1', '2020-04-23 20:00:32');
INSERT INTO `record` VALUES ('6', '1', '2020-04-23 20:41:28');
INSERT INTO `record` VALUES ('7', '1', '2020-04-23 20:56:27');
INSERT INTO `record` VALUES ('8', '1', '2020-04-24 11:27:46');
INSERT INTO `record` VALUES ('9', '1', '2020-04-25 11:27:46');
INSERT INTO `record` VALUES ('10', '1', '2020-04-26 10:43:26');
INSERT INTO `record` VALUES ('11', '1', '2020-04-27 13:17:21');
INSERT INTO `record` VALUES ('12', '1', '2020-04-27 13:21:09');
INSERT INTO `record` VALUES ('13', '1', '2020-04-27 13:22:11');
INSERT INTO `record` VALUES ('14', '1', '2020-04-27 13:25:42');
INSERT INTO `record` VALUES ('15', '1', '2020-04-27 13:34:20');
INSERT INTO `record` VALUES ('16', '1', '2020-04-27 13:36:23');
INSERT INTO `record` VALUES ('17', '1', '2020-05-04 14:21:10');
INSERT INTO `record` VALUES ('18', '1', '2020-05-04 17:44:30');
INSERT INTO `record` VALUES ('19', '1', '2020-05-04 17:48:57');
INSERT INTO `record` VALUES ('20', '1', '2020-05-04 17:49:49');
INSERT INTO `record` VALUES ('24', '1', '2020-05-06 21:09:22');
INSERT INTO `record` VALUES ('25', '1', '2020-05-06 21:16:07');
INSERT INTO `record` VALUES ('26', '1', '2020-05-06 21:43:29');
INSERT INTO `record` VALUES ('27', '1', '2020-05-09 19:35:54');
INSERT INTO `record` VALUES ('28', '1', '2020-05-10 11:49:50');
INSERT INTO `record` VALUES ('29', '1', '2020-05-10 11:50:57');
INSERT INTO `record` VALUES ('30', '1', '2020-05-10 11:56:14');
INSERT INTO `record` VALUES ('31', '1', '2020-05-10 11:57:01');
INSERT INTO `record` VALUES ('32', '1', '2020-05-10 11:58:34');
INSERT INTO `record` VALUES ('33', '1', '2020-05-10 12:32:32');
INSERT INTO `record` VALUES ('34', '1', '2020-05-10 13:12:30');
INSERT INTO `record` VALUES ('35', '1', '2020-05-10 13:15:35');
INSERT INTO `record` VALUES ('36', '1', '2020-05-10 13:15:36');
INSERT INTO `record` VALUES ('37', '1', '2020-05-10 13:17:26');
INSERT INTO `record` VALUES ('38', '1', '2020-05-10 13:34:10');
INSERT INTO `record` VALUES ('39', '1', '2020-05-10 15:10:50');
INSERT INTO `record` VALUES ('40', '1', '2020-05-10 15:38:46');
INSERT INTO `record` VALUES ('41', '1', '2020-05-10 16:03:38');
INSERT INTO `record` VALUES ('42', '1', '2020-05-15 10:31:21');
INSERT INTO `record` VALUES ('43', '1', '2020-05-16 12:47:45');
INSERT INTO `record` VALUES ('45', '1', '2020-05-17 18:53:43');
INSERT INTO `record` VALUES ('46', '1', '2020-05-17 18:54:52');
INSERT INTO `record` VALUES ('47', '1', '2020-05-17 18:57:17');
INSERT INTO `record` VALUES ('48', '1', '2020-05-17 19:00:42');
INSERT INTO `record` VALUES ('49', '1', '2020-05-17 19:09:11');
INSERT INTO `record` VALUES ('50', '1', '2020-05-17 19:09:21');
INSERT INTO `record` VALUES ('51', '1', '2020-05-17 19:13:20');
INSERT INTO `record` VALUES ('52', '1', '2020-05-17 19:20:30');
INSERT INTO `record` VALUES ('53', '1', '2020-05-17 19:28:46');
INSERT INTO `record` VALUES ('54', '1', '2020-05-17 19:39:17');
INSERT INTO `record` VALUES ('55', '1', '2020-05-17 19:39:37');
INSERT INTO `record` VALUES ('56', '1', '2020-05-17 19:39:54');
INSERT INTO `record` VALUES ('57', '1', '2020-05-17 19:40:45');
INSERT INTO `record` VALUES ('58', '1', '2020-05-17 19:44:40');
INSERT INTO `record` VALUES ('59', '1', '2020-05-17 19:45:28');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `studiedTag` int(11) DEFAULT '1',
  `numberTag` int(11) DEFAULT '0',
  `levelTag` int(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `levelone` int(11) DEFAULT NULL,
  `leveltwo` int(11) DEFAULT NULL,
  `levelthree` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小明', '13912345678', '男', '1', '0', '1', null, '1', '2', '3');

-- ----------------------------
-- Table structure for userprogress
-- ----------------------------
DROP TABLE IF EXISTS `userprogress`;
CREATE TABLE `userprogress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `studiedTag` int(11) DEFAULT '1',
  `numberTag` int(11) DEFAULT '0',
  `levelTag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userprogress
-- ----------------------------
INSERT INTO `userprogress` VALUES ('1', '1', '3', '3', '1');
INSERT INTO `userprogress` VALUES ('2', '1', '1', '1', '4');
INSERT INTO `userprogress` VALUES ('3', '1', '1', '1', '6');
INSERT INTO `userprogress` VALUES ('4', '1', '1', '0', '12');
INSERT INTO `userprogress` VALUES ('5', '1', '2', '0', '5');
INSERT INTO `userprogress` VALUES ('6', '1', '1', '0', '2');
INSERT INTO `userprogress` VALUES ('7', '1', '2', '5', '7');
INSERT INTO `userprogress` VALUES ('8', '1', '2', '0', '3');

-- ----------------------------
-- Table structure for word
-- ----------------------------
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) DEFAULT NULL,
  `pinyin` varchar(255) DEFAULT NULL,
  `audio` varchar(255) DEFAULT NULL,
  `explanation` varchar(255) DEFAULT NULL,
  `sentence1` varchar(255) DEFAULT NULL,
  `pinyin1` varchar(255) DEFAULT NULL,
  `sentence2` varchar(255) DEFAULT NULL,
  `pinyin2` varchar(255) DEFAULT NULL,
  `sentence3` varchar(255) DEFAULT NULL,
  `pinyin3` varchar(255) DEFAULT NULL,
  `tag` int(11) DEFAULT NULL,
  `findlevel` int(11) DEFAULT NULL,
  `likeword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word
-- ----------------------------
INSERT INTO `word` VALUES ('1', '春季', 'chūn', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '他不会居中着变长吗，我也不知道好不好看头秃头秃', 'chūn tiān', '他不会居中着变长吗，我也不知道好不好看头秃头秃', 'chūn jié', '他不会居中着变长吗，我也不知道好不好看头秃，头秃', 'chūn jì', '1', '1', '青');
INSERT INTO `word` VALUES ('2', '冬天', 'dōng', '冬.m4a', '1.冬季。2.姓。3.同“咚”', '冬天', 'dōng tiān', '寒冬', 'hán dōng', '丁冬', 'dīng dōng', '1', '1', '佟');
INSERT INTO `word` VALUES ('3', '风', 'fēng', '风.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '1', '凤');
INSERT INTO `word` VALUES ('4', '雪', 'xuě', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '2', '青');
INSERT INTO `word` VALUES ('5', '花', 'huā', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '2', '青');
INSERT INTO `word` VALUES ('6', '风', 'fēng', '风.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '2', '凤');
INSERT INTO `word` VALUES ('7', '雪', 'xuě', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '3', '青');
INSERT INTO `word` VALUES ('8', '花', 'huā', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '3', '青');
INSERT INTO `word` VALUES ('9', '春', 'chūn', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '3', '青');
INSERT INTO `word` VALUES ('10', '冬', 'dōng', '冬.m4a', '1.冬季。2.姓。3.同“咚”', '冬天', 'dōng tiān', '寒冬', 'hán dōng', '丁冬', 'dīng dōng', '1', '1', '青');
INSERT INTO `word` VALUES ('11', '风', 'fēng', '风.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '1', '佟');
INSERT INTO `word` VALUES ('12', '雪', 'xuě', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '1', '凤');
INSERT INTO `word` VALUES ('13', '花', 'huā', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '2', '青');
INSERT INTO `word` VALUES ('14', '风', 'fēng', '风.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '2', '青');
INSERT INTO `word` VALUES ('15', '雪', 'xuě', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '2', '凤');
INSERT INTO `word` VALUES ('16', '花', 'huā', '春.m4a', '1.春季。 2.指一年的时间。 3.指男女情欲。 4.比喻生机。 5.姓。', '春天', 'chūn tiān', '春节', 'chūn jié', '春季', 'chūn jì', '1', '3', '青');

-- ----------------------------
-- Table structure for wrongword
-- ----------------------------
DROP TABLE IF EXISTS `wrongword`;
CREATE TABLE `wrongword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wordId` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wrongword
-- ----------------------------
INSERT INTO `wrongword` VALUES ('1', '1', '2020-04-22 16:55:29', '1');
INSERT INTO `wrongword` VALUES ('2', '1', '2020-04-23 11:50:17', '1');
