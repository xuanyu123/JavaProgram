<template>
  <div class="index-footer">
    <el-row>
      <el-col :span="21" :offset="1">
        <el-row style="margin-top: 5px;text-align: center;">
          <hr />
          <p style="color: #999;font-size: 12px;">
            © 2020 山西农业大学二手交易系统 版权所有
          </p>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
      name: "index-footer"
    }
</script>

<style scoped>
  .index-footer{
    margin-bottom: 0px;
    position:relative;
    width:100%;
    bottom: 0;/*始终距离它的父元素的底部为0px.则是处于父元素的最底*/
  }
</style>
