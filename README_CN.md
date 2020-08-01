# 异星工厂音乐生成器
把midi音乐转换为异星工厂的音乐盒蓝图。  
![Java CI with Maven](https://github.com/khjxiaogu/FactorioComposer/workflows/Java%20CI%20with%20Maven/badge.svg)  
# Usage  
1. 确保已经安装java 8+。  
2. 从[Releases](https://github.com/khjxiaogu/FactorioComposer/releases)下载最新版的jar。  
3. 双击运行下载的jar。  
4. 选择midi文件或者文件夹来导入。  
5. 复制弹出窗口中的蓝图代码。  
6. 在异星工厂中导入蓝图并放置。  
7. 在旁边放一个音乐盒驱动器 [蓝图](https://github.com/khjxiaogu/FactorioComposer/blob/master/MusicDriver.md)。
8. 用绿线安装箭头指示接上。  
![instruction](https://res.khjxiaogu.com/piclib/db48c091-958d-4916-83c9-9bb002a9c0c5.jpg)  
[在github看图](https://github.com/khjxiaogu/FactorioComposer/blob/master/instruction.jpg)  
9. 设置输出信号为 __"M" "A" "X" "V"__ 的常量箱子的 __"V"__ 信号数值为蓝图标题上面的ticks。  
10. 关闭输出信号为 __"P" "A" "U" "S" "E"__的常量箱子。  
11. 享受~~  
# 注意事项
- 异星工厂只能播放从F2到E8的音符, 低于F2的音符会用鼓来演奏, 高于E8的音符会用三角铁演奏。
- 音乐tick是游戏tick的一半，大多数音乐在30UPS（是游戏60UPS的一半）的情况下有比较好的性能。音乐盒驱动器的显示值单位为秒。  
- 游戏UPS会大幅度影响播放速率.
- __不支持通道信息!__ 你应该使用[Aria Maestosa](https://github.com/ariamaestosa/ariamaestosa)来导入midi然后直接导出到原文件以进行预处理。否则音乐的不同音轨会不同步！  
