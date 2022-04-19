<template>
  <body class="main-container">
      <div class="icon">
          <img src="../img/TechElevator_PBS_RGB_ccexpress.png">
      </div>    
      <div class="header">
        <h1>le chat bot.</h1>
      </div>
      <div class="sidebar">
          <sidebar />
      </div>
      <div class="content">
          <login-container v-if="isLogin"/>
          <register-container v-if="isRegister" />
          <chat-bot-container v-if="this.$route.name==='home'" />
      </div>
      
      
  </body>
</template>

<script>
import Sidebar from '@/components/Sidebar';
import LoginContainer from './LoginContainer.vue';
import ChatBotContainer from './ChatBotContainer.vue';
import RegisterContainer from './RegisterContainer.vue';

export default {
    name: "main-container",
    components: {
        Sidebar,
        LoginContainer, 
        ChatBotContainer,
        RegisterContainer
    },
    computed: {
        isLogin() {
            return this.$route.name === 'login';
        },
        isRegister() {
            return this.$route.name === 'register';
        }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');

.main-container {
    height: 95vh;
    display: grid;
    grid-template-columns: 1fr 5fr;
    grid-template-rows: 15vh 3fr;
    grid-template-areas: 
        "icon header"
        "sidebar content";
    
}

.content-container {
        height: 100%;
    }

.bot-container {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }

.icon {
    height: 100%;
    grid-area: icon;
    background-color: #04ACF4;
    text-align: center
}

.icon > img {
    max-height: 100%;
    max-width: 100%;
    object-fit: contain;
}

.header {
    height: 100%;
    grid-area: header;
    background-color: #04ACF4;
    display: flex;
    align-items: center;
}

.content {
    grid-area: content;
    padding-top: 10px;
    padding-left: 10px;
    background-color: #F5F7F3;
    font-family: 'Roboto', sans-serif;
    color: #1F2B4A;
    border: 1px solid #1F2B4A;
}

.header > h1 {
    color: #F5F7F3;
    font-family: 'Playfair Display', serif;
    font-size: 12vh;
    padding-left: 5%;
    height: 100%;
    width: 100%;
}

button {
    background-color: white;
    color: #1F2B4A;
    border: 2px solid #1F2B4A;
    height: 10vh;
    min-width: 150px;
    max-width: 60vh;
    border-radius: 4px;
    font-size: 2.5vh;
    margin-top: 1vh;
    margin-bottom: 1vh;
    margin-left: 1vh;
    margin-right: 1vh;
}

.bubble {
    font-size: 2.5vh;
    color: #F5F7F3;
    border-radius: 8px;
    flex-grow: 1;
    margin-left: 20px;
    margin-right: 20px;
    padding: 5px;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    text-align: center;
  }

button:hover {
    background-color: #04ACF4;
    color: white;
}

button:disabled,
button[disabled] {
    background-color: #F5F7F3;
    color: #1F2B4A;
}


</style>