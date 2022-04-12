<template>
  <div>
    <input type="text" v-model="userName" v-on:keyup.enter="saveName" placeholder="Type your name here">
    <button type="submit" @click.prevent="saveName">Submit</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userName: null
    }
  },
  methods: {
    saveName() {
      this.$store.commit('SET_USER_NAME', this.userName);
    }
  }

}
</script>

<style>

</style>