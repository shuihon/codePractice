package dena;

/**
 * Created by @gaofenglin
 * on 2024/3/31.
 */

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

public class OrderProcessTest {

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
                    //将料理种类，存入map中，
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
                //创建，oven内正在转的菜,不关心顺序 hashmap
                //数组结构的话，关心顺序
                //存的内容是某个东西的数量
                //存储某道菜有几个微波炉在转
                HashMap<Integer, Integer> dishInOven = new HashMap<>();
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
                            //如果不存在orderNum
                            if (!dishInOven.containsKey(orderNum)) {
                                dishInOven.put(orderNum, 0);
                            }//先取出再➕1
                            dishInOven.put(orderNum, dishInOven.get(orderNum) + 1);
                            System.out.println(orderNum);
                        } else {
                            System.out.println("wait");
                            orderDeque.offer(orderNum);
                        }
                    } else if (inputLine.startsWith("complete")) {
                        String[] parts = inputLine.split(" ");
                        int completeNum = Integer.parseInt(parts[1]);
                        if (dishInOven.containsKey(completeNum)) {
                            //deque,remove直接从开头remove
                            //有三道西红柿在三个微波炉里转
                            //拿出开头那个微波炉里转的西红柿，最后变成2道西红柿在2个微波炉，一个空微波炉
                            dishInOven.put(completeNum, dishInOven.get(completeNum) - 1);
                            //考虑微波炉里面的某个菜是否转完，为0时，就不在dishInOven中
                            if (dishInOven.get(completeNum) == 0) {
                                dishInOven.remove(completeNum);
                            }
                            ovenAvailable++;
                            if (orderDeque.isEmpty()) {
                                System.out.println("ok");
                            } else {
                                //取出并删除poll
                                //orderDeque.poll();
                                //取出不删除 peek
                                int next = orderDeque.peek();
//                                dishInOvenIsExist(next,dishInOven);
//                                IsExist.isExist(next,dishInOven);
                                if (!dishInOven.containsKey(next)) {
                                    dishInOven.put(next, 0);
                                }
                                dishInOven.put(next, dishInOven.get(next) + 1);
                                //微波炉减1，表示把菜放入微波炉
                                ovenAvailable--;
                                System.out.println("ok " + orderDeque.poll());
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

    private static void dishInOvenIsExist(int next, HashMap dishInOven) {
        if (!dishInOven.containsKey(next)) {
            dishInOven.put(next, 0);
        }
    }


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


}



