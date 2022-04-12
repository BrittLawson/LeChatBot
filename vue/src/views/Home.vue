<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <chat-bot></chat-bot>
  </div>
</template>

<script>

import ChatBot from '@/components/ChatBot.vue';

export default {
  name: "home",
  components: {
    ChatBot
  }
};
</script>
