学习笔记

## 二查找前提
- 目标函数单调性
- 存上下界
- 数组随机访问


## 代码模板
```java
List<T> array;
int left = 0;
int right = array.size();

while (left <= right) {
    int mid = (left + right) / 2;
    if (array.get(mid) == target) {
        // find target 
        break or return result
    } else if (array.get(mid) < target) {
        left = mid + 1;
    } else {
        righ = mid - 1；
    }
}
```