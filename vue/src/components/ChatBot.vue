<template>
  <div>
    <h1>ChatBot</h1>
    <h3>Ask a question, or ask for help to see a list of topics I can help you with!</h3>
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