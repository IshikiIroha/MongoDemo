package cn.mldn.mongodb;

import com.mongodb.*;

import java.util.regex.Pattern;

public class MongoTest {
    public static void main(String[] args) throws Exception {
        MongoClient client = new MongoClient("localhost",27001);//2.x取得连接对象
        DB db = client.getDB("mldn");//2.x取得数据库对象
        if(db.authenticate("mldn","java".toCharArray())){//2.x驱动认证
            DBCollection col = db.getCollection("dept");//取得集合对象
//            //1.数据插入
//            for(int x=0;x<100;x++){
//                BasicDBObject obj = new BasicDBObject();//构造基础对象
//                obj.append("deptno",1000+x);//append()追加字段或对象，嵌套调用就是在一个结构里面加
//                obj.append("dname","技术部-"+x);
//                obj.append("loc","上海-"+x);
//                col.insert(obj);
//            }
//            //2.条件查询与分页
//            DBObject condition = new BasicDBObject();//查询条件也用对象表示
//            condition.put("deptno",new BasicDBObject("$gte",1000).append("$lte",1006));//put()也是追加字段或对象，但嵌套调用是在同一层级添加
//            DBCursor cursor = col.find(condition).skip(6).limit(1);//游标指向查询内容，可全部，可分页
//            while(cursor.hasNext()){
//                DBObject obj = cursor.next();
//                System.out.println("部门编号:"+obj.get("deptno")+","+"部门名称:"+obj.get("dname"));
//            }
//            //3.范围查询
//            DBObject condition = new BasicDBObject();
//            condition.put("deptno",new BasicDBObject("$in",new int[]{1001,1003,1005}));
//            DBCursor cursor = col.find(condition).skip(0).limit(10);
//            while(cursor.hasNext()){
//                DBObject obj = cursor.next();
//                System.out.println("部门编号:"+obj.get("deptno")+","+"部门名称:"+obj.get("dname"));
//            }
//            //4.模糊查询
//            DBObject condition = new BasicDBObject();
//            Pattern pattern = Pattern.compile("6");// 等效于\\d+6
//            condition.put("dname",new BasicDBObject("$regex",pattern));//MongoDB只支持对字符串字段模糊查询
//            DBCursor cursor = col.find(condition).skip(0).limit(10);
//            while(cursor.hasNext()){
//                DBObject obj = cursor.next();
//                System.out.println("部门编号:"+obj.get("deptno")+","+"部门名称:"+obj.get("dname"));
//            }
//            //5.数据修改
//            DBObject conditionA = new BasicDBObject();
//            DBObject conditionB = new BasicDBObject();
//            DBObject conditionC = new BasicDBObject();
//            conditionA.put("deptno",1000);
//            conditionB.put("$set",new BasicDBObject("dname","修改后的部门名称"));
//            conditionC.put("deptno",new BasicDBObject("$gte",1000).append("$lte",1006));
//            WriteResult resultA = col.update(conditionA,conditionB);//writeResult为修改结果
//            System.out.println(resultA.getN());//getN()为修改的数据量
//            WriteResult resultB = col.updateMulti(conditionC,conditionB);//updateMulti()更改多行，writeResult为修改结果
//            System.out.println(resultB.getN());//getN()为修改的数据量
            //6.数据删除
            DBObject condition = new BasicDBObject();
            condition.put("deptno",1099);
            WriteResult result = col.remove(condition);//writeResult为修改结果
            System.out.println(result.getN());//getN()为修改的数据量
        }
        client.close();//关闭连接
    }

}
