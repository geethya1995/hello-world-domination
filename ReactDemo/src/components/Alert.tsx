// Creating components that can accept children components

import { ReactNode } from "react";

interface AlertProps {
  //   text: string;
  //   children: string;
  children: ReactNode;
}
const Alert = ({ children }: AlertProps) => {
  return <div className="alert alert-primary">{children}</div>;
};

export default Alert;
