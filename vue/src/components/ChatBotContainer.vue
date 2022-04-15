<template>
  <div class="chat-container">
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

<style style="scoped">
    div {
        height: 98%;
    }

    .bot-container {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }


  .input-field {
    max-height: 100px;
    display: flex;
    justify-content: center;
    align-items: flex-end;
    padding-left: 20px;
    padding-right: 20px;
  }

  .input-field input{
    height: 50px;  
    flex-grow: 1;
    font-size: 1.5em;
  }

  .input-field button {
    height: 50px;
    width: 100px;
    margin-left: 25px;
    background-color: white;
    color: #1F2B4A;
    border: 2px solid #1F2B4A;
    border-radius: 4px;
  }

  .input-field button:hover {
    background-color: #04ACF4;
    color: white;
  }
</style>