import axios from 'axios'

const API_URL = import.meta.env.VITE_OSCAR_URL || 'http://localhost:9912/oscar'

class OscarService {
  getLoosers() {
    return axios.get(API_URL + '/directors/get-loosers')
  }

  rewardThriller() {
    return axios.post(API_URL + '/movies/reward-thriller')
  }
}
export default new OscarService()
