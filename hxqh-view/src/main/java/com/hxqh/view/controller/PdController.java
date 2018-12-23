package com.hxqh.view.controller;

import com.hxqh.view.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Created by Ocean lin on 2018/12/20.
 *
 * @author Ocean lin
 */

@Controller
@RequestMapping("pd")
public class PdController {

    @Autowired
    private RedisService redisService;

    /**
     * http://127.0.0.1:8999/pd/list?topnum=8
     * http://127.0.0.1:8999/pd/list?topnum=3
     *
     * @param model
     * @param topnum
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, Integer topnum) {
//         String test = redisService.getStr("test");
//         model.addAttribute("test", test);

        Map<String, List<String>> map = redisService.getAllData("pingdaoid");
        Set<Map.Entry<String, List<String>>> set = map.entrySet();
        Map<Long, String> sortmap = new TreeMap<Long, String>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.valueOf((long) o2 - (long) o1 + "");
            }
        });

        for (Map.Entry<String, List<String>> entry : set) {
            String pindaoid = entry.getKey();
            List<String> list = entry.getValue();
            Long total = 0L;
            for (String o : list) {
                total += Long.valueOf(o);
            }
            // 总数有相同的ID
            if (sortmap.get(total) != null) {
                String pindaoidtemp = sortmap.get(total);
                sortmap.put(total, pindaoidtemp + "," + pindaoid);
            } else {
                sortmap.put(total, pindaoid);
            }
        }

        int temptotal = 0;
        Set<Map.Entry<Long, String>> sortmapset = sortmap.entrySet();
        List<String> result = new ArrayList<String>();
        for (Map.Entry<Long, String> entry : sortmapset) {
            String pindaoid = entry.getValue();
            String[] temp = pindaoid.split(",");
            temptotal += temp.length;
            if (temptotal >= topnum) {
                int sy = temptotal - topnum;
                int tempqz = temp.length - sy - 1;
                for (int i = 0; i <= tempqz; i++) {
                    result.add(temp[i] + ":" + entry.getKey());
                }
                break;
            } else {
                for (String tempinner : temp) {
                    result.add(tempinner + ":" + entry.getKey());
                }
            }
        }

        model.addAttribute("result", result);
        return "dsrdlist";
    }
}
