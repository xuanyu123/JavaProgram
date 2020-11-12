<template>
  <div>
    <!--      首页条-->
    <index-header></index-header>
    <div class="message">
      <v-input v-model="username"></v-input>
      <v-textarea v-model="message" ref="message"></v-textarea>
      <div class="btn-con">
        <input @click="handleSend" type="button" class="btn" value="发布"/>
      </div>
    </div>
    <div class="content">
      <el-table
        :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
        style="width: 100%">
        <el-table-column
          label="昵称"
          prop="username">
        </el-table-column>
        <el-table-column
          label="内容"
          prop="message">
        </el-table-column>
      </el-table>
      <el-row :gutter="20" style="margin-top: 20px;">
        <el-col :span="18" :offset="1">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[5, 10, 20, 40]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="tableData.length">
          </el-pagination>
        </el-col>
      </el-row>
    </div>
    <!--      首页尾-->
    <index-footer></index-footer>
  </div>
</template>
<script>
import IndexHeader from './index-header'
import IndexFooter from './index-footer'
import vInput from './vInput.vue'
import vTextarea from './vTextarea.vue'
import vList from './vList.vue'
export default {
  data () {
    return {
      currentPage:1, //初始页
      pageSize:5, //每页的数据
      tableData: [],
    }
  },
  components: {
    IndexHeader,
    IndexFooter,
    vInput,
    vTextarea,
    vList
  },

  mounted() {
    //  使用生命周期和ajax加载数据
    this.init()
  },

  methods: {
    
    init(){
      let self = this;
      //加载文字数据
      $.get("http://localhost:8083/message/getMessage.do",function (data) {
        self.tableData = data;
        //加载商品主图
        element.username = data.username;
        element.message = data.message;
        //引起 Vue 重新渲染
        self.$set(self.tableData,index,element);
      },"json");
    },
    
    // 初始页currentPage、初始每页数据数pageSize和数据data
    handleSizeChange: function (size) {
      this.pageSize = size;
      // console.log(this.pageSize)  //每页下拉显示数据
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
      // console.log(this.currentPage)  //点击第几页
    },


    handleSend: function () {
      if (this.username === '') {
        window.alert('请输入昵称')
        return
      }
      if (this.message === '') {
        window.alert('请输入留言内容')
        return
      }
      // 数组list存储了所有的留言内容，通过函数给list添加一项留言数据，添加成功后把文本框置空

      let jsonObj = {};
      jsonObj.username = this.username;
      jsonObj.message = this.message;
      let jsonMsg = JSON.stringify(jsonObj);
      let self = this;
      $.ajax({
        type: "POST",
        url: "http://localhost:8083/message/setMessage.do",
        data: JSON.stringify(jsonObj),
        dataType:"json",
        contentType:"application/json",
        success:function (data) {

        }
      });
      this.init()
    },
  }
}
</script>

<style scoped>
.content {
  margin-left: 200px;
  margin-right: 200px;
}

.message {
    width: 80%;
    margin: 0 auto;
    padding-top: 80px;
}
.message div{
  margin: auto;
}
.message input:focus,
.message textarea:focus{
  border: 1px solid #3399ff;
  border-radius: 5px;
}
.message .btn-con{
  text-align: center;
  padding-top: 10px;
  padding-right: 0px;
}
.message .btn{
  padding: 6px 15px;
  border: 1px solid #39f;
  border-radius: 4px;
  color: #fff;
  background-color: #39f;
  cursor: pointer;
  outline: none;
}
</style>
