package com.yj.login;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yj.login.dto.MenuDTO;
import com.yj.login.entity.Menu;
import com.yj.login.mapper.MenuMapper;
import com.yj.login.service.MenuService;
import com.yj.login.utils.BeanCopyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class LoginApplicationTests {



    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuService menuService;



    @Test
    void contextLoads() {
    }

    @Test
    void test(){
//        List<Integer> menuIds = menuMapper.selectList(new LambdaQueryWrapper<Menu>()
//                        .select(Menu::getId)
//                        .eq(Menu::getParentId, 2))
//                         .stream()
//                         .map(Menu::getId)
//                         .collect(Collectors.toList());
        List<Menu> menus = menuMapper.selectList(new LambdaQueryWrapper<Menu>()
                .select(Menu::getId)
                .eq(Menu::getParentId, 2));


        System.out.println(menus);
    }

    @Test
    void test2(){
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Menu(6,"发布文章","/articles","/article/Article.vue","el-icon-myfabiaowenzhang",1,2,0,null,null));

        map.put("a",list);
        Object b = map.get("b");

        List<Menu> menuList = menuMapper.listMenusByUserInfoId(1);
        Map<Integer, List<Menu>> childrenMap = getMenuMap(menuList);
        List<Menu> catalogList = listCatalog(menuList);
//        System.out.println(childrenMap);
//        System.out.println("====================");
//        List<Menu> children = childrenMap.get(catalogList.get(0).getId());
//        System.out.println(childrenMap);
        List<MenuDTO> list1 = BeanCopyUtils.copyList(childrenMap.get(2), MenuDTO.class);
        System.out.println(list1);
    }

    @Test
    void test3(){
        //定义其实值
        int i=0;
        //定义能换的汽水数量
        int b=0;
        outer:
        while (i<10){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入你手上的空瓶子数量");
                int h = scanner.nextInt();
                if (h<1||h>100){
                    System.out.println("输入有误请重新输入");
                    continue outer;
                }else {
                    if (h % 3 == 1) {
                    b=h/3+1;
                    i++;
                }else {
                    b=h/3;
                    i++;
                }
                    scanner.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }


    private Map<Integer, List<Menu>> getMenuMap(List<Menu> menuList) {
        return menuList.stream()
                .filter(item-> Objects.nonNull(item.getParentId()))
                .collect(Collectors.groupingBy(Menu::getParentId));
    }

    private List<Menu> listCatalog(List<Menu> menuList) {
        return menuList.stream()
                .filter(item -> Objects.isNull(item.getParentId()))
                .sorted(Comparator.comparing(Menu::getOrderNum))
                .collect(Collectors.toList());
    }

    @Test
    void search(){
        int[] arr=new int[6];
        arr[0]=0;
        arr[1]=3;
        arr[2]=6;
        arr[3]=1;
        arr[4]=5;
        System.out.println(arr[binanrySearch(arr,5)]);
    }

    private int binanrySearch(int[]arr, int key){
        //定义最小索引值
        int low=0;
        //定义最大索引值
        int high= arr.length;
        while (low<high){
            int mid= (int) Math.floor((low+high)/2);
            if (key==arr[mid]){
                return mid;
            }
            if (key>arr[mid]){
                low=mid+1;
            }if (key<arr[mid]){
                high=mid-1;
            }
        }
        return -1;
    }



}
