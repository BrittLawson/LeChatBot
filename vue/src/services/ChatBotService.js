import axios from 'axios';

export default {

  getResponse(queryString) {
    return axios.get(`/?query=${encodeURIComponent(queryString)}`);
  }

}