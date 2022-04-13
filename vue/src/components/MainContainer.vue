<template>
  <body class="main-container">
      <div class="icon">
          <img src="..\img\TechElevator_PBS_RGB_ccexpress.png">
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

<style style="scoped">
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');

.main-container {
    height: 95vh;
    display: grid;
    grid-template-columns: 1fr 5fr;
    grid-template-rows: 100px 3fr;
    grid-template-areas: 
        "icon header"
        "sidebar content";
}

.icon {
    grid-area: icon;
    background-color: #04ACF4;
    display: flex;
    justify-content: center
}

img {
    max-height: 100%;
    max-width: 100%;
    object-fit: cover;
}

.header {
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
    color: #1F2B4A
}

h1 {
    color: #F5F7F3;
    font-family: 'Playfair Display', serif;
    font-size: 4em;
    padding-left: 5%;
}

</style>