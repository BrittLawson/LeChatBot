<template>
  <div class="content-container">
    <div class="bot-container">
      
      <bot-speech-bubble v-if="!invalidCredentials && !this.$route.query.registration" :speechText="'Meow! I\'m Oliver, your friendly Tech Elevator chat bot! Before we do anything else, let\'s get you logged in!'" />
      <bot-speech-bubble v-if="invalidCredentials" :speechText="'Meow! Invalid username and password!'" /> 
      <bot-speech-bubble v-if="this.$route.query.registration" :speechText="'Thank you for registering, meow! Please sign in!'" />  
      
      <form class="form-login" @submit.prevent="login">
        <div class="input-container">
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus 
          />
            
            
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required 
         /> 
            

          
          
          </div>
          
          <div class="button-container">
          <button class="login-button" type="submit">Sign me in!</button>
          <button class="login-button" v-on:click="register()">I'd like to make an account, please!</button>
          </div>
      
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import BotSpeechBubble from './BotSpeechBubble.vue';

export default {
  components: { BotSpeechBubble },
  name: "login-container",
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },

  computed: {
    loginText() {
      if (this.$route.query.registration) {
        return "sdfsf";
      } else return 'Meow! I\'m Oliver, your friendly Tech Elevator chat bot! Before we do anything else, let\'s get you logged in!'
    }
  },

  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    register() {
        this.$router.push("/register");
    }
  }

}
</script>

<style>

.input-container {
    display: flex;
    align-items: center;
}

.button-container {
    display: flex;
    align-items: center;
    justify-content: center;
}

.form-login {
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
}

.login-button {
  margin: 10px;
}



</style>