###Demo1(冒泡，选择，插入排序)
    /**
     * 数组简单排序
     */
    public class Demo1 {
        private static final int[] arrs = {45, 12, 46, 20, 48, 33};
    
        public static void main(String[] args) {
            //冒泡排序
            //bubbleSort(arrs);
            //选择排序
            //selectSort(arrs);
            //简化版选择排序
            //betterSelectSort(arrs);
            //插入排序
            insertSort(arrs);
    
        }
    
    
        /**
         * 冒泡排序
         * 保证最大值在最后面
         *
         * @param arrs
         */
        static void bubbleSort(int[] arrs) {
            beforeSort(arrs);
            for (int i = 0; i < arrs.length; i++) {
                for (int j = 0; j < arrs.length - 1 - i; j++) {
                    if (arrs[j] > arrs[j + 1]) {
                        int temp = arrs[j];
                        arrs[j] = arrs[j + 1];
                        arrs[j + 1] = temp;
                    }
                    printHint(arrs, i, j);
                }
                System.out.println();
            }
        }
    
    
        /**
         * 选择排序
         * 保证最左边的最小
         *
         * @param arrs
         */
        private static void selectSort(int[] arrs) {
            beforeSort(arrs);
            for (int i = 0; i < arrs.length - 1; i++) {
                for (int j = i + 1; j < arrs.length; j++) {
                    if (arrs[i] > arrs[j]) {
                        int temp = arrs[j];
                        arrs[j] = arrs[i];
                        arrs[i] = temp;
                    }
                    printHint(arrs, i, j);
                }
                System.out.println();
            }
        }
    
        /**
         * 大大的减少数组变动次数
         *
         * @param arrs
         */
        private static void betterSelectSort(int[] arrs) {
            beforeSort(arrs);
            for (int i = 0; i < arrs.length - 1; i++) {
                int k = i;
                for (int j = i + 1; j < arrs.length; j++) {
                    if (arrs[k] > arrs[j]) k = j;
                }
                if (k != i) {
                    int temp = arrs[i];
                    arrs[i] = arrs[k];
                    arrs[k] = temp;
                }
                System.out.print("第" + (i + 1) + "次遍排序:" + "\t\t");
                for (int x : arrs) {
                    System.out.print(x + "\t");
                }
                System.out.println();
    
            }
        }
    
    
        /**
         * 插入排序,认为左边的数是有序数列
         *
         * @param arrs
         */
        private static void insertSort(int[] arrs) {
            beforeSort(arrs);
            int count = 0;
            for (int i = 1; i < arrs.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arrs[j] < arrs[j - 1]) {
                        int temp = arrs[j - 1];
                        arrs[j - 1] = arrs[j];
                        arrs[j] = temp;
                    } else {
                        break;
                    }
                    System.out.print("第" + ++count + "次遍排序:" + "\t\t");
                    for (int x : arrs) {
                        System.out.print(x + "\t");
                    }
                }
                System.out.println();
            }
    
        }
    
        /**
         * 这体现代码，复用
         *
         * @param arrs
         */
        private static void beforeSort(int[] arrs) {
            System.out.print("排序前:\t\t\t");
            for (int k : arrs) {
                System.out.print(k + "\t");
            }
            System.out.println();
        }
    
        /**
         * 这体现代码，复用
         * 同样你也可以把数组交换的代码抽做一个方法，
         *
         * @param arrs
         * @param i
         * @param j
         */
        private static void printHint(int[] arrs, int i, int j) {
            System.out.print("第" + (i + 1) + "次" + "第" + (j + 1) + "遍排序:" + "\t\t");
            for (int k : arrs) {
                System.out.print(k + "\t");
            }
        }
    
    }
#####冒泡排序
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step1.png?raw=true)
####选择排序
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step2.png?raw=true)
####优化选择排序
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step3.png?raw=true)
####插入排序
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step4.png?raw=true)
###Demo2(二分法查找)
    /**
     * 二分法查找
     * <p>
     * 前提：必须是有序数组
     */
    public class Demo2 {
        private static final int[] arrs = {45, 12, 46, 20, 48, 33};
    
        private static final int[] arrs1 = {45, 12, 46, 20, 48, 33};
    
        public static void main(String[] args) {
            //首先排序数组
            insertSort(arrs);
            sop(arrs);
            //查找
            int index = binaryFind(arrs, 20);
    
            int index2 = binaryFind(arrs, 90);
    
            sop(index, 20);
            sop(index2, 90);
            System.out.println("================系统自带的Arrays类=================");
            Arrays.sort(arrs1);
            System.out.println(Arrays.toString(arrs1));
            System.out.println("20查找的位置：" + Arrays.binarySearch(arrs1, 20));
            System.out.println("90查找的位置：" + Arrays.binarySearch(arrs1, 90));
    
        }
    
        private static void sop(int index, int key) {
            System.out.println();
            if (index != -1) {
                System.out.println(key + "的位置为:" + index);
            } else {
                System.out.println("没有找到" + key + "的位置");
            }
        }
    
        private static int binaryFind(int[] arrs, int key) {
            //数组操作 下标是关键
            //定义下标
            int min = 0;//最小值下标
            int max = arrs.length - 1;//最大值下标
            int mid = arrs.length / 2;//中间值下标
            while (min < max) {//查找的终止条件
                if (arrs[mid] > key) {//表明key在数组前部分
                    max = mid - 1;
                } else if (arrs[mid] < key) {//表明key在数组后半部分
                    min = mid + 1;
                } else {
                    return mid;//找到下标
                }
                mid = (min + max) / 2;//中间下标也要改变
            }
            return -1;
        }
    
    
        private static void sop(int[] arrs) {
            System.out.println("排序后:");
            for (int k : arrs) {
                System.out.print(k + "\t");
            }
        }
    
        private static void insertSort(int[] arrs) {
            for (int i = 1; i < arrs.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arrs[j] < arrs[j - 1]) {
                        int temp = arrs[j - 1];
                        arrs[j - 1] = arrs[j];
                        arrs[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
####运行结果:
![](https://github.com/mar-sir/JavaForAndroid/blob/master/JavaForAndroid/series3/src/main/java/images/step5.png?raw=true)