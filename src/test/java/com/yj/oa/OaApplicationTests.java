package com.yj.oa;

import com.yj.oa.project.mapper.PermissionMapper;
import com.yj.oa.project.mapper.RolePermissionMapper;
import com.yj.oa.project.service.attendCount.IAttendCountService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests{

    @Autowired
    RolePermissionMapper mapper;

    @Autowired
    IAttendCountService iAttendService;

    @Autowired
    TaskService taskService;

    @Autowired
    PermissionMapper permissionMapper;

    @Test
    public void contextLoads()
    {

//        Date date=DateUtils.StrToDate("2018-10-10 11:12:11");
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        System.out.println(c.get(Calendar.HOUR_OF_DAY));
//        System.out.println(c.get(Calendar.MINUTE));
//        System.out.println(c.get(Calendar.SECOND));
    }
}