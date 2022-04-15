<template>
  <div class="content-container">
      <chat-bot-intro v-if="$store.state.nameOfCurrentUser==''"/>
      <chat-bot v-else />
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

  .input-field {
    height: 12vh;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .input-field input{
    height: 8vh; 
    flex-grow: 1;
    font-size: 5vh;
    margin: 10px;
  }

  .message-container {
    display: flex;
    height: 10vh;
 }

 #rbc {
   width: 100%;
   display: flex;
   justify-content: space-evenly;
 }

 

</style>