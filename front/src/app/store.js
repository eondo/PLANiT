import { atom } from 'recoil';

// 로그인 체크
export const isLogin = atom({
  key: 'isLogin',
  // default: false,
  default: true,
});

export const dateRangeState = atom({
  key: 'dateRangeState',
  default: { startDate: new Date(), endDate: new Date() },
});