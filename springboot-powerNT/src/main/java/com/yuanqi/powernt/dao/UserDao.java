package com.yuanqi.powernt.dao;

import com.yuanqi.powernt.model.UserInfo;
import pnbclient.infobase.PageActionInInfo;
import pnbclient.infobase.PageActionOutInfo;

import java.sql.Date;
import java.util.List;

public class UserDao {

    //操作别名对象
    private pnbclient.alias.SQLCommandService aliasSrv = null;
    //操作sql语句对象
    private pnbclient.command.SQLCommandService sqlSrv = null;


    public UserDao(){
        try {
            aliasSrv = new pnbclient.alias.SQLCommandService();
            sqlSrv = new pnbclient.command.SQLCommandService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List getList(){
        aliasSrv.setLangId("sc");
        List list=aliasSrv.getList("MS_ReserveConfigureDao_GetReserveGlobalConfigList_SQL");
        return list;
    }
    /**
     * 获取所有用户
     * @return
     */
    public List getAllUser() {
        List list = null;
        try {
            aliasSrv.setLangId("sc");
//            list = aliasSrv.getList("find_all_user_sql");
            list=aliasSrv.getListBean("find_all_user_sql", UserInfo.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过用户id获取用户信息
     * @param userId
     * @return
     */
    public List getUserById(String userId) {
        List list = null;
        List list123 = null;
        List list456 = null;
        try {
            aliasSrv.setLangId("sc");
            aliasSrv.addParameter("userid", userId);
//            list = aliasSrv.getList("find_all_user_byid_sql");
            list = aliasSrv.getListBean("find_all_user_byid_sql",UserInfo.class);
//			srv.setLangId("sc");
//			srv.addParameter("userid", userId);
//			list123 =srv.getListMap("find_all_user_byid_sql");
//			srv.setLangId("sc");
//			srv.addParameter("userid", userId);
//			list456=srv.getListBean("find_all_user_byid_sql",UserInfo.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 使用别名的方式：添加用户
     */
    public void addUser(){
        try {
            aliasSrv.setLangId("sc");
            aliasSrv.addParameter("jack");
            aliasSrv.addParameter("杰克");
            aliasSrv.addParameter("'96E79218965EB72C92A549DD5A330112'");
            aliasSrv.addParameter("0");
            aliasSrv.addParameter("0");
            aliasSrv.addParameter("1");
            aliasSrv.addParameter(new Date(System.currentTimeMillis()));
            aliasSrv.addParameter("1");
            aliasSrv.addParameter("1");
            aliasSrv.execute("save_user_sql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 别名方式：批量添加操作
     */
    public void batchAddUser(){
        try {
            String sqlCommand1="save_user_sql";
            String sqlCommand2="save_user2_sql";
            final String[] sqlCommandString = new String[]{sqlCommand1, sqlCommand2};
            aliasSrv.setLangId("sc");
            aliasSrv.addParameter(0,"rose1");
            aliasSrv.addParameter(0,"如斯");
            aliasSrv.addParameter(0,"'96E79218965EB72C92A549DD5A330112'");
            aliasSrv.addParameter(0,"0");
            aliasSrv.addParameter(0,"0");
            aliasSrv.addParameter(0,"1");
            aliasSrv.addParameter(0,new Date(System.currentTimeMillis()));
            aliasSrv.addParameter(0,"1");
            aliasSrv.addParameter(0,"1");

            aliasSrv.setLangId("sc");
            aliasSrv.addParameter(1,"lisi");
            aliasSrv.addParameter(1,"李四");
            aliasSrv.addParameter(1,"'96E79218965EB72C92A549DD5A330112'");
            aliasSrv.addParameter(1,"0");

            aliasSrv.executeBatch(sqlCommandString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * sql方式：添加用户信息
     */
    public void addUserBySql(){
        try {
            String sqlCommand="insert into fd_user(userid,username,password,disabled) values(?,?,?,?)";
            sqlSrv.setLangId("sc");

            sqlSrv.addParameter("wangwu8");
            sqlSrv.addParameter("王五8");
            sqlSrv.addParameter("96E79218965EB72C92A549DD5A330112");
            sqlSrv.addParameter("0");
            sqlSrv.execute(sqlCommand);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public List getListPage(){

        //实例化分页对象
        PageActionInInfo pagein = new PageActionInInfo();
        pagein.setRowsperpage(Integer.parseInt("5"));//页大小
        pagein.setPageaction("NextPage");//FirstPage首页,PriorPage上一页,NextPage下一页，LastPage末页,ToPaged跳转
        pagein.setCurrentpagenum(Integer.parseInt("2"));//当前页
        pagein.setTopagenum(Integer.parseInt("1"));//当动作为ToPage时，这里设置要跳转的页面

        //声明传出分页对象
        PageActionOutInfo pageout = new PageActionOutInfo();
        aliasSrv.setLangId("sc");
//        List list = aliasSrv.getListMap("find_all_user_sql", pagein, pageout);
        List list =  aliasSrv.getListBean("find_all_user_sql", pagein, pageout,UserInfo.class);

        return list;
    }

}
