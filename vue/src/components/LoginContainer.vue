<template>
  <div class="login-container">
      <bot-speech-bubble v-if="!invalidCredentials && !this.$route.query.registration" :speechText="'Meow! I\'m Oliver, your friendly Tech Elevator chat bot! Before we do anything else, let\'s get you logged in!'" />
        <form class="form-signin" @submit.prevent="login">
        <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      ><bot-speech-bubble :speechText="'Meow! Invalid username and password!'" /></div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      ><bot-speech-bubble :speechText="'Thank you for registering, meow! Please sign in!'" /></div>
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
      <br>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /> 
      <br>
      <button class="signin-button" type="submit">Sign me in!</button>
      </div>
      <div class="button-container">
        <br>
        <button class="register-button" v-on:click="register()">I'd like to make an account, please!</button>
      </div>
      
    </form>
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

.login-container {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding-left: 20px;
    padding-right: 20px;
}

.input-container {
    display: flex;
}

.button-container {
    display: flex;
    align-items: center;
    justify-content: center;
}

.form-signin {
    height: 100%;
    margin-top: 15px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
}

.form-control {
    height: 50px;  
    font-size: 1.5em;
    margin: 15px;
}

button {
    height: 50px;
    min-width: 150px;
    margin-top: 15px;
    margin-left: 25px;
    background-color: white;
    color: #1F2B4A;
    border: 2px solid #1F2B4A;
    border-radius: 4px;
}

button:hover {
    background-color: #04ACF4;
    color: white;
}

.register-button {
    height: 50px;

    margin-left: 25px;
    background-color: white;
    color: #1F2B4A;
    border: 2px solid #1F2B4A;
    border-radius: 4px;
}

</style>