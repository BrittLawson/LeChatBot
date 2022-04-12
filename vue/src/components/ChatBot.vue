<template>
  <div>
    <h1>ChatBot</h1>
    <h3>Hey there, {{ this.$store.state.nameOfCurrentUser }}!</h3>
    <h3>{{ this.$store.state.currentResponseObject.message }}</h3>
    <chat-bot-input />
  </div>
</template>

<script>
import ChatBotInput from '@/components/ChatBotInput.vue';
export default {
  components: {
    ChatBotInput
  }
}
</script>

<style>

</style>