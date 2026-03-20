"""
人生曲线 - Life Curve Visualization
用 Python 绘制你的人生轨迹
"""

import matplotlib
matplotlib.use('Agg')  # 非交互式后端，直接保存图片
import matplotlib.pyplot as plt
import numpy as np
from matplotlib import font_manager
import matplotlib.dates as mdates
from datetime import datetime

# 尝试设置中文字体
try:
    plt.rcParams['font.sans-serif'] = ['Microsoft YaHei', 'SimHei', 'SimSun', 'KaiTi', 'FangSong']
    plt.rcParams['axes.unicode_minus'] = False
except:
    pass

def create_life_curve():
    """创建人生曲线图"""
    
    # ========== 在波折中下降的人生曲线 ==========
    # 格式: (年龄, 幸福/满意度 1-10, 阶段名称)
    # 整体下行，但途中有所起伏
    life_data = [
        (0, 9, "童年"),
        (8, 8, "少年"),
        (15, 6, "青春"),
        (20, 7, "短暂回升"),
        (25, 5, "低谷"),
        (30, 6, "挣扎"),
        (35, 4, "困顿"),
        (40, 5, "喘息"),
        (45, 3, "滑落"),
        (50, 4, "起伏"),
        (55, 2, "谷底"),
        (60, 3, "余波"),
        (65, 2, "暮年"),
        (70, 1, "尾声"),
    ]
    
    ages = [d[0] for d in life_data]
    scores = [d[1] for d in life_data]
    labels = [d[2] for d in life_data]
    
    # 创建平滑曲线
    ages_smooth = np.linspace(min(ages), max(ages), 200)
    scores_smooth = np.interp(ages_smooth, ages, scores)
    
    # 创建图形
    fig, ax = plt.subplots(figsize=(14, 8))
    
    # 填充区域
    ax.fill_between(ages_smooth, 0, scores_smooth, alpha=0.3, color='#4A90D9')
    ax.plot(ages_smooth, scores_smooth, linewidth=3, color='#2E5C8A', 
            label='人生轨迹')
    
    # 标记关键节点
    scatter = ax.scatter(ages, scores, c=scores, cmap='viridis', 
                        s=120, zorder=5, edgecolors='white', linewidths=2)
    
    # 添加阶段标签
    for age, score, label in life_data:
        ax.annotate(label, (age, score), textcoords="offset points", 
                    xytext=(0, 15), ha='center', fontsize=9, 
                    fontweight='bold', color='#333333')
    
    # 设置坐标轴
    ax.set_xlim(-2, max(ages) + 5)
    ax.set_ylim(0, 11)
    ax.set_xlabel('年龄 Age', fontsize=12, fontweight='bold')
    ax.set_ylabel('幸福指数 (1-10)', fontsize=12, fontweight='bold')
    ax.set_title('在波折中下降的人生曲线', fontsize=18, fontweight='bold', pad=20)
    
    # 添加网格
    ax.grid(True, alpha=0.3, linestyle='--')
    ax.set_axisbelow(True)
    
    # 添加水平参考线
    for y in [5, 7, 9]:
        ax.axhline(y=y, color='gray', linestyle=':', alpha=0.5)
    
    # 美化
    ax.spines['top'].set_visible(False)
    ax.spines['right'].set_visible(False)
    
    plt.tight_layout()
    plt.savefig('life_curve.png', dpi=150, bbox_inches='tight', 
                facecolor='white', edgecolor='none')
    plt.close()
    print("Saved: life_curve.png")

if __name__ == "__main__":
    create_life_curve()
