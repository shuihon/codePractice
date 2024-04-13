package dena;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by @gaofenglin
 * on 2024/3/30.
 * 1 (step 0ne
 * 2 (menu kinds
 * 100 5 700 (food numb; storage; price
 * 50 2 300
 * order 13 100 4 (seat number; food number ; order quantity
 * order 12 100 2
 * order 11 100 1
 */

public class OrderProcess {

    public static void main(String[] args) {
        HashMap<Integer, Food> foodHashMap = new HashMap<>();
        Scanner myScanner = new Scanner(System.in);
        String line = myScanner.nextLine();
        switch (line) {
            case "1":
                int menuKinds = Integer.parseInt(myScanner.nextLine());
                for (int i = 0; i < menuKinds; i++) {
                    Food food = new Food();
                    String[] menuInfo = myScanner.nextLine().split(" ");
                    int foodNumb = Integer.parseInt(menuInfo[0]);
                    food.setFoodNumb(foodNumb);
                    int storage = Integer.parseInt(menuInfo[1]);
                    food.setStorage(storage);
                    int price = Integer.parseInt(menuInfo[2]);
                    food.setPrice(price);
                    foodHashMap.put(foodNumb, food);

                }
                while (myScanner.hasNext("order")) {
                    String[] orderInfo = myScanner.nextLine().split(" ");
                    int seatNum = Integer.parseInt(orderInfo[1]);
                    int orderFoodNumber = Integer.parseInt(orderInfo[2]);
                    int orderQuantity = Integer.parseInt(orderInfo[3]);
                    if (foodHashMap.containsKey(orderFoodNumber)) {
                        Food matchingFood = foodHashMap.get(orderFoodNumber);
                        if (matchingFood.getStorage() < orderQuantity) {
                            System.out.println("sold out " + seatNum);
                        } else {
                            int foodStorage = matchingFood.getStorage();
                            foodStorage -= orderQuantity;
                            matchingFood.setStorage(foodStorage);
                            for (int i = 0; i < orderQuantity; i++) {
                                System.out.println("received order " + seatNum + " " + orderFoodNumber);
                            }

                        }
                    }
                }
                break;
//            case "2":
//                String[] menuAndOven = myScanner.nextLine().split(" ");
//                int secondMenuKinds = Integer.parseInt(menuAndOven[0]);
//                int ovenAvailable = Integer.parseInt(menuAndOven[1]);
//                for (int i = 0; i < secondMenuKinds; i++) {
//                    Food secondFood = new Food();
//                    String[] menuInfo = myScanner.nextLine().split(" ");
//                    int foodNumb = Integer.parseInt(menuInfo[0]);
//                    secondFood.setFoodNumb(foodNumb);
//                    int storage = Integer.parseInt(menuInfo[1]);
//                    secondFood.setStorage(storage);
//                    int price = Integer.parseInt(menuInfo[2]);
//                    secondFood.setPrice(price);
//                    foodHashMap.put(foodNumb, secondFood);
//                }
//                Deque<String> deque = new ArrayDeque<>();
//                HashMap<Integer, ReceivedOrder> receivedOrderHashMap = new HashMap<>();
//                while (myScanner.hasNext("received")) {
//                    String[] orderInfo = myScanner.nextLine().split(" ");
//                    deque.offer(orderInfo[3]);
//                    ReceivedOrder receivedOrder = new ReceivedOrder();
//                    //设置received行的foodNum
//                    //key   String料理单号，对象也是料理单号
//                    receivedOrder.setFoodNum(Integer.parseInt(orderInfo[3]));
//                    receivedOrderHashMap.put(Integer.parseInt(orderInfo[3]), receivedOrder);
//                    //进入队列，有可用微波炉
//                    if (ovenAvailable - 1 > 0) {
//                        ovenAvailable -= 1;
//                        System.out.println(orderInfo[3]);
//                    } else {
//                        System.out.println("wait");
//                    }
//                }
//                while (myScanner.hasNext("complete")) {
//                    String[] completeInfo = myScanner.nextLine().split(" ");
//                    int completeNum = Integer.parseInt(completeInfo[1]);
//                    //是否有这个料理单号
//                    if (receivedOrderHashMap.containsKey(completeInfo)) {
//                        //完成一单
//                        deque.poll();
//                        ovenAvailable += 1;
//                        if (deque.isEmpty()) {
//                            System.out.println("ok");
//                        } else {
//                            String result = deque.stream()
//                                    .collect(Collectors.joining(" "));
//                            System.out.println(result);
//                            System.out.print("ok" + " " + result);
//                        }
//                    } else {
//                        System.out.println("unexpected input");
//                    }
//                }
//                break;
//            case "2":
//                // 初始化
//                String[] menuAndOven = myScanner.nextLine().split(" ");
//                int secondMenuKinds = Integer.parseInt(menuAndOven[0]);
//                int ovenAvailable = Integer.parseInt(menuAndOven[1]);
//                // 省略了添加Food到foodHashMap的循环
//
//                Deque<String> deque = new ArrayDeque<>();
//                HashMap<Integer, ReceivedOrder> receivedOrderHashMap = new HashMap<>();
//
//                // 合并while循环，使用hasNextLine确保读到文本末尾
//                while (myScanner.hasNextLine()) {
//                    String lineInput = myScanner.nextLine();
//                    if (lineInput.startsWith("received")) {
//                        // 处理received情况
//                        String[] orderInfo = lineInput.split(" ");
//                        deque.offer(orderInfo[3]);
//                        ReceivedOrder receivedOrder = new ReceivedOrder();
//                        // 设置received行的foodNum
//                        receivedOrder.setFoodNum(Integer.parseInt(orderInfo[3]));
//                        receivedOrderHashMap.put(Integer.parseInt(orderInfo[3]), receivedOrder);
//                        if (ovenAvailable - 1 >= 0) {
//                            ovenAvailable -= 1;
//                            System.out.println(orderInfo[3]);
//                        } else {
//                            System.out.println("wait");
//                        }
//                    } else if (lineInput.startsWith("complete")) {
//                        // 处理complete情况
//                        String[] completeInfo = lineInput.split(" ");
//                        int completeNum = Integer.parseInt(completeInfo[1]);
//                        if (receivedOrderHashMap.containsKey(completeNum)) {
//                            if (deque.isEmpty()) {
//                                System.out.println("ok");
//                            } else {
//                                // 完成一单
//                                deque.poll();
//                                ovenAvailable += 1;
//                                String result = deque.stream()
//                                        .collect(Collectors.joining(" "));
//                                System.out.println("ok" + " " + result);
//                            }
//                        } else {
//                            System.out.println("unexpected input");
//                        }
//                    }
//                }
//                break;
//            case "2":
//                String[] menuAndOven = myScanner.nextLine().split(" ");
//                int secondMenuKinds = Integer.parseInt(menuAndOven[0]);
//                int ovenAvailable = Integer.parseInt(menuAndOven[1]);
//                for (int i = 0; i < secondMenuKinds; i++) {
//                    Food secondFood = new Food();
//                    String[] menuInfo = myScanner.nextLine().split(" ");
//                    int foodNumb = Integer.parseInt(menuInfo[0]);
//                    secondFood.setFoodNumb(foodNumb);
//                    int storage = Integer.parseInt(menuInfo[1]);
//                    secondFood.setStorage(storage);
//                    int price = Integer.parseInt(menuInfo[2]);
//                    secondFood.setPrice(price);
//                    foodHashMap.put(foodNumb, secondFood);
//                }
//
//                Deque<Integer> orderDeque = new ArrayDeque<>();
//                while (myScanner.hasNextLine()) {
//                    String inputLine = myScanner.nextLine().trim();
//                    if (inputLine.isEmpty()) {
//                        break; // 处理输入结束
//                    }
//
//                    if (inputLine.startsWith("received")) {
//                        String[] parts = inputLine.split(" ");
//                        int orderNum = Integer.parseInt(parts[3]);
//                        if (ovenAvailable > 0) {
//                            ovenAvailable--;
//                            orderDeque.offer(orderNum);
//                            System.out.println(orderNum);
//                        } else {
//                            System.out.println("wait");
//                        }
//                    } else if (inputLine.startsWith("complete")) {
//                        String[] parts = inputLine.split(" ");
//                        int completeNum = Integer.parseInt(parts[1]);
//                        if (!orderDeque.isEmpty() && orderDeque.peek().equals(completeNum)) {
//                            orderDeque.poll();
//                            ovenAvailable++;
//                            if (orderDeque.isEmpty()) {
//                                System.out.println("ok");
//                            } else {
//                                System.out.println("ok " + orderDeque.peek());
//                            }
//                        } else {
//                            System.out.println("unexpected input");
//                        }
//                    }
//                }
//                break;
            case "2":
                String[] menuAndOven = myScanner.nextLine().split(" ");
                int secondMenuKinds = Integer.parseInt(menuAndOven[0]);
                int ovenAvailable = Integer.parseInt(menuAndOven[1]);
                for (int i = 0; i < secondMenuKinds; i++) {
                    Food secondFood = new Food();
                    String[] menuInfo = myScanner.nextLine().split(" ");
                    int foodNumb = Integer.parseInt(menuInfo[0]);
                    secondFood.setFoodNumb(foodNumb);
                    int storage = Integer.parseInt(menuInfo[1]);
                    secondFood.setStorage(storage);
                    int price = Integer.parseInt(menuInfo[2]);
                    secondFood.setPrice(price);
                    foodHashMap.put(foodNumb, secondFood);
                }
                Deque<Integer> orderDeque = new ArrayDeque<>();
                while (myScanner.hasNextLine()) {
                    String inputLine = myScanner.nextLine().trim();
                    if (inputLine.isEmpty()) {
                        break;
                    }

                    if (inputLine.startsWith("received")) {
                        String[] parts = inputLine.split(" ");
                        int orderNum = Integer.parseInt(parts[3]);
                        if (ovenAvailable > 0) {
                            ovenAvailable--;
                            orderDeque.offer(orderNum);
                            System.out.println(orderNum);
                        } else {
                            System.out.println("wait");
                            orderDeque.offer(orderNum); // 即使微波炉不够也应当记录订单
                        }
                    } else if (inputLine.startsWith("complete")) {
                        String[] parts = inputLine.split(" ");
                        int completeNum = Integer.parseInt(parts[1]);
                        if (orderDeque.contains(completeNum)) {
                            // 如果订单在队列中，则完成该订单，并从队列中移除
                            orderDeque.remove(Integer.valueOf(completeNum)); // 移除指定订单号
                            ovenAvailable++;
                            if (orderDeque.isEmpty()) {
                                System.out.println("ok");
                            } else {
                                System.out.println("ok " + orderDeque.peek()); // 显示下一个订单
                            }
                        } else {
                            System.out.println("unexpected input");
                        }
                    }
                }
                break;

            case "3":
                break;
            case "4":
                break;
        }
    }

    //    K微波炉个数
//    使用的微波炉几个，变量
    // 微波炉有空时
//    int属于类
//    int i=0;
//    i属于该类某一个对象
    /*
    static 属于类，不需要创建对象
    非static 属于对象，需要创建对象调用

    static方法：方法内{
    1.用static属性（方法等）new food对象
   特殊： 2.用非static的属性 ，是属于一个具体OrderProcess对象，不能直接用
    要new 一个OrderProcess对象，由此对象调用即可
    非static方法：方法内：{
    1.用static方法属性等，可以使用，因为属于类
    2.用非static方法属性可以吗？
    非static本本身也是属于某一个对象，this
     */
//public void test(){
//    this.test1=1;
//}
    //static?
    static class Food {
        int foodNumb = 0;
        int storage = 0;
        int price = 0;

        public int getFoodNumb() {
            return foodNumb;
        }

        public void setFoodNumb(int foodNumb) {
            this.foodNumb = foodNumb;
        }

        public int getStorage() {
            return storage;
        }

        public void setStorage(int storage) {
            this.storage = storage;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    static class ReceivedOrder {
        int seatNum;
        int foodNum;

        public int getFoodNum() {
            return foodNum;
        }

        public void setFoodNum(int foodNum) {
            this.foodNum = foodNum;
        }
    }
}


