<template>
  <div>
    <input type="text" v-model="queryString" v-on:keyup.enter="sendQuery" placeholder="Type your question here">
    <button type="submit" @click.prevent="sendQuery">Submit</button>
  </div>
</template>

<script>
import chatBotService from '@/services/ChatBotService.js';
export default {
    data() {
    return {
      queryString: null
    }
  },
  methods: {
    sendQuery() {
      this.$store.commit('SET_QUERY_STRING', this.queryString);
      chatBotService.getResponse(this.$store.state.currentQueryString)
        .then(response => {
          this.$store.commit('SET_RESPONSE_OBJECT', response);
        })
        .catch(error => {
          if (error.response && error.response.status === 404) {
            alert ("No information found. Please try again.")
          }
        });
      this.queryString = null;
    }
  }
}
</script>

<style>

</style>