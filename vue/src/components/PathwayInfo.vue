<template>
  <div id="pathway-topic-container">
    <section v-for="topic in $store.state.pathwayTopics" :key="topic.id">
        <router-link :to="{ name: topic.routeName }">
          <button class="pathway-topic-button" v-on:click="pathway()" :disabled="$store.state.nameOfCurrentUser==''">
          {{ topic.linkText }}   
          </button> 
        </router-link>
    </section>
    <button class="pathway-topic-button" v-on:click="home()" :disabled="$store.state.nameOfCurrentUser==''">
        Take me back to the main Chatbot home page.  
    </button>
  </div>
</template>

<script>
export default {
  name: "pathway-info",
  methods: {
    home () {
      this.$router.push("/")
    }
  }
  
}
</script>

<style>
  
</style>