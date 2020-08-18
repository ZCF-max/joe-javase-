# question

## 第1题
**题目：** 拆读数字（三位数），例如：153翻译成一百五十三。

## 第2题
**题目：** 打印1-2000之间既能被3整除又能被8整除的前15个数，逢5换行。

## 第3题
**题目：** 输出菲波拉契数列的前20项（1，1，2，3，5，8…）。

## 第4题
**题目：** 编写程序算出1！+2！+3！+ … +10！的和。（3！标识1*2*3）。

## 第5题
**题目：** 判断101-200之间有多少个素数，并输出所有素数，除了1和本身不能被任何数整除的数叫素数。

## 第6题
**题目：** 有8根梅花桩，有个武林高手在第一桩上开始向前走，在走到第8根时转身向后走，当走到第1根再转身向前，求走到50步的时候，人站在哪根桩子上。

## 第7题
**题目：** 打印100-1000的水仙花数，水仙花数：其各位置上的数字的立方和等于该数字本身。

## 第8题
**题目：** 打印九九乘法表。

## 第9题
**题目：** 打印10行杨辉三角（每个数等于它上面的数加上它上面的左边的数）。
- 1
- 1	1
- 1	2 1
- 1	3 3 1
- 1	4 6 4 1

## 第10题
**题目：** 有一个程序大赛，三个班级各有四名同学，挨次利用Scanner录入，计算每个班级参赛学员的平均分。

# answer

## 第1题
**答案：** 
```java
@Test
public void work01() {
    int yourNum = 400;
    String result = "数字无效";
    String numStr = " 一二三四五六七八九";

    // 将接到的数进行判断，如果是三位数，执行，如果不是输出数字无效
    if (yourNum > 99 && yourNum < 1000) {

        // 将三位数拆成三部分 456
        int bai = yourNum / 100;
        int shi = yourNum / 10 % 10;
        int ge = yourNum % 10;
        char baiWei = numStr.charAt(bai);
        char shiWei = numStr.charAt(shi);
        char geWei = numStr.charAt(ge);
        result =
                shi == 0 && ge == 0 ? baiWei + "百" :
                shi == 0 && ge != 0 ? baiWei + "百零" + geWei :
                shi != 0 && ge == 0 ? baiWei + "百" + shiWei : baiWei + "百" + shiWei + "十" + geWei;
    }
    System.out.println(result);
}
```

## 第2题
**答案：**
```java
/**
 * 打印1-2000之间既能被3整除又能被8整除的前15个数，逢5换行。
 */
@Test
public void work02() {
    int count = 0;
    for (int i = 1; i <= 2000; i++) {
        if (i % 3 == 0 && i % 8 == 0 && count < 15) {
            System.out.print(i + "\t");
            count++;
            if (count % 5 == 0) {
                System.out.println();
            }
        }
    }
}
```

## 第3题
**答案：**
```java
/**
 * 输出菲波拉契数列的前20项（1，1，2，3，5，8…）。
 */
@Test
public void work03() {
    int a = 1, b = 1;
    for (int i = 0; i < 20; i++) {
        System.out.print(a + "\t");
        System.out.print(b + "\t");
        // 新a = 旧a + 旧b
        // 新b = 新a + 旧b
        a = a + b;
        b = a + b;
    }
}
```

## 第4题
**答案：**
```java
/**
 * 编写程序算出1！+2！+3！+ … +10！的和。（3！标识1*2*3）。
 */
@Test
public void work04() {
    int sum = 0, factorial = 1;
    for (int i = 1; i <= 10; i++) {
        // 这就是阶乘 1 * 1 * 2 * 3 * 4...
        factorial *= i;
        sum += factorial;
    }
    System.out.println(sum);
}
```

## 第5题
**答案：**
```java
/**
 * 判断101-200之间有多少个素数，并输出所有素数，除了1和本身不能被任何数整除的数叫素数。
 */
@Test
public void work05() {
    int count = 0;
    for (int dividend = 101; dividend <= 200; dividend++) {
        // 除数，每次都从2开始
        int divisor = 2;
        while (dividend > divisor) {
            if (dividend % divisor == 0) {
                // 它是不是素数
                break;
            }
            // 每次除数都要增加，从2一直加到被除数。
            divisor++;
        }

        // 如果除数已经增加到被除数的值，说明之前没有能除尽的情况，就是素数
        if (dividend == divisor) {
            count++;
            System.out.println(dividend);
        }
    }
    System.out.println(count + "个素数");
}
```

## 第6题
**答案：**
```java
/**
 * 有8根梅花桩，有个武林高手在第一桩上开始向前走，在走到第8根时转身向后走，
 * 当走到第1根再转身向前，求走到50步的时候，人站在哪根桩子上。
 */
@Test
public void work01() {

    // 桩号
    int zNo = 1;

    // 反方向（向左走）
    boolean flag = false;

    for (int i = 0; i < 50; i++) {

        if (zNo == 1 || zNo == 8) {
            flag = !flag;
        }

        zNo = flag ? zNo + 1 : zNo - 1;
    }
    System.out.println(zNo);
}
```

## 第7题
**答案：**
```java
/**
 * 打印100-1000的水仙花数，水仙花数：其各位置上的数字的立方和等于该数字本身，水仙花数必须是三位数。
 */
@Test
public void work02() {
    for (int i = 100; i <= 1000; i++) {
        int bai = i / 100, shi = i / 10 % 10, ge = i % 10;
        if (i == Math.pow(bai, 3) + Math.pow(shi, 3) + Math.pow(ge, 3)) {
            System.out.println(i);
        }
    }
}
```

## 第8题
**答案：**
```java
/**
 * 九九乘法表。
 */
@Test
public void work03() {
    String result;
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i; j++) {
            result = i * j < 10 ? "0" + (i * j) : "" + i * j;
            System.out.printf("%d*%d=%s\t", j, i, result);
        }
        System.out.println();
    }
}
```

## 第9题
**答案：**
```java
/**
 * 打印10行杨辉三角（每个数等于它上面的数加上它上面的左边的数）。
 */
@Test
public void work04() {
    
    // 行列
    int n = 10;

    int[][] arr = new int[n][n];
    int len = arr.length;

    // 第一列和最后一列铺满1
    for (int i = 0; i < len; i++) {
        arr[i][0] = 1;
        arr[i][i] = 1;
    }

    // 设置中间的值
    // 行设置：第一行是1，第二行是1 1 ，均已写好，所以直接从第三行开始遍历
    for (int i = 2; i < len; i++) {
        // 列设置：第一列全是1，所以直接从第二列开始遍历，最后一列全是1，所以遍历到i-1，从1开始，所以"<="
        for (int j = 1; j <= i - 1; j++) {
            // 规律：自己 = 自己上面的数 + 自己上面的数的左边的数
            arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
        }
    }

    // 按照九九乘法表的方式展示这个二维数组
    for (int i = 0; i < len; i++) {
        for (int j = 0; j <= i; j++) {
            System.out.print(arr[i][j] + "\t");
        }
        System.out.println();
    }
}

// 整合结果
int n = 10;
int[][] arr = new int[n][n];
for (int i = 0, k = arr.length; i < k; i++) {
    for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
            arr[i][j] = 1;
        } else {
            arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
        }
        System.out.print(arr[i][j] + " ");
    }
    System.out.println();
}
```

## 第10题
**答案：**
```java
/**
 * 有一个程序大赛，三个班级各有四名同学，挨次利用Scanner录入，计算每个班级参赛学员的平均分。
 */
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    for (int classNo = 1; classNo <= 3; classNo++) {
        double sum = 0;
        for (int studentNo = 1; studentNo <= 4; studentNo++) {
            System.out.printf(">> 输入第%d个班级第%d个同学的成绩\n", classNo, studentNo);
            sum += scanner.nextDouble();
        }
        System.out.printf(">> 第%s个班的平均成绩为%.2f分\n\n", classNo, sum / 4);
    }
    System.out.println(">> 录入结束...");
    scanner.close();
}
```