<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <chat-bot-container />
  </div>
</template>

<script>

import ChatBotContainer from '@/components/ChatBotContainer.vue';

export default {
  name: "home",
  components: {
    ChatBotContainer
  }
};
</script>
