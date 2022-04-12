<template>
  <div>
      <div>
          <chat-bot-intro v-if="$store.state.nameOfCurrentUser==''"/>
          <chat-bot v-else />
      </div>
      <div>

      </div>
  </div>
</template>

<script>
import ChatBotIntro from '@/components/ChatBotIntro.vue';
import ChatBot from '@/components/ChatBot.vue';

export default {
    name: "chatbot-container",
    components: {
        ChatBotIntro,
        ChatBot
    }
}
</script>

<style>

</style>