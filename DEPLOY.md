# 部署说明

## 方式一：GitHub Pages（推荐，免费）

### 1. 创建 GitHub 仓库
- 打开 https://github.com/new
- 仓库名可填 `portfolio` 或 `hanyu-zhao`
- 选择 Public，**不要**勾选 "Add a README"
- 点击 Create repository

### 2. 推送代码
在项目目录执行：

```powershell
cd c:\projects\code
git add index.html .gitignore .github .vercelignore
git commit -m "Add personal website"
git branch -M main
git remote add origin git@github.com:hot-zhy/freya.git
git push -u origin main
```

### 3. 启用 GitHub Pages
- 进入仓库 → **Settings** → **Pages**
- **Source** 选择 **GitHub Actions**
- 等待约 1 分钟，部署完成后访问：**https://hot-zhy.github.io/freya/**

---

## 方式二：Vercel（需先登录）

### 1. 登录 Vercel
```powershell
npx vercel login
```
按提示在浏览器中完成登录。

### 2. 部署
```powershell
cd c:\projects\code
npx vercel --prod
```
部署成功后会得到类似 `https://xxx.vercel.app` 的链接。

---

## 方式三：Netlify Drop（无需命令行）

1. 打开 https://app.netlify.com/drop
2. 将 `index.html` 文件拖入页面
3. 即可获得一个临时访问链接
