<template>
  <div>
    <div v-for="topic in $store.state.pathwayTopics" :key="topic.id">
      <router-link :to="{ name: topic.routeName }">{{ topic.linkText }}</router-link>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style>
  
</style>