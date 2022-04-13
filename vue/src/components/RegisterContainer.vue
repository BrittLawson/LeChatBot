<template>
<div class="registration-container">
      <bot-speech-bubble v-if="!registrationErrors" :speechText="'Choose a username and password, meow!'" />
        <form class="form-register" @submit.prevent="register">
        <div
        class="alert alert-danger"
        role="alert"
        v-if="registrationErrors"
      ><bot-speech-bubble :speechText="registrationErrorMsg" /></div>

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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <br>
      
      </div>
      <div class="button-container">
        <button class="register-button" type="submit">Sign up</button>
        <br>
        <button class="gotologin-button" v-on:click="goToLogin()">Actually, I already have an account!</button>
      </div>
      
    </form>
  </div>
  

</template>

<script>
import authService from '../services/AuthService';
import BotSpeechBubble from './BotSpeechBubble.vue';

export default {
    name: "register-container",
    components: {
        BotSpeechBubble
    },
    data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'Meow! Something went wrong.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Meow-oh! Your password didn\t match the password confirmation!';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Meow! Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'Meow! There were problems registering this user.';
    },
    goToLogin() {
        this.$router.push("/login");
    }
  },

}
</script>

<style>

.registration-container {
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
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

.form-register {
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

.gotologin-button {
    height: 50px;

    margin-left: 25px;
    background-color: white;
    color: #1F2B4A;
    border: 2px solid #1F2B4A;
    border-radius: 4px;
}
</style>