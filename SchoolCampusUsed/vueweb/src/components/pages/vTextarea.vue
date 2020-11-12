<template>
  <div class="input-con">
    <span>留言内容：</span>
    <!--ref 被用来给元素或子组件注册引用信息。
    引用信息将会注册在父组件的 $refs 对象上。
    如果在普通的 DOM 元素上使用，引用指向的就是 DOM 元素；
    如果用在子组件上，引用就指向组件实例：  -->
    <textarea
    type="text"
    :value="value"
    @input="updateValue"
    placeholder="请输入想要购买的物品"></textarea>
  </div>
</template>
<script>
  export default {
  // 接收父组件传入的value
  props: {
    value: {
      type: String,
      default: ''
    }
  },
  methods: {
    // 监听input值
    updateValue: function (event) {
      this.$emit('input', event.target.value)
    },
    focus: function () {
      // 一个对象，持有注册过ref特性的所有DOM元素和组件实例。
      this.$refs.message.focus()
    }
  }
}
</script>
<style scoped>
.input-con{
  display: flex;
  flex-direction: row;
  justify-content: center;
}
span{
  width: 100px;
  display: inline-block;
  text-align: right;
  vertical-align: top;
}
textarea{
  border: 1px solid #e6e6ee;
  padding: 4px 5px;
  line-height: 24px;
  border-radius: 5px;
  width: 400px;
  height: 200px;
}
</style>
