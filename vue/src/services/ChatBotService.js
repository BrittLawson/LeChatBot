import axios from 'axios';

export default {

  getResponse(queryString) {
    return axios.get(`/response/?query=${encodeURIComponent(queryString)}`);
  }

}