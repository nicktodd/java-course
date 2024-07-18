
# Window Applications

## The Aims

In this lab you will create a graphical user interface to enable a user to access various functionality of a banking application. We will now create a desktop application to enable users to access their account information with a menu driven about dialog.

![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPMAAABwCAIAAABEsNEeAAAAAXNSR0IArs4c6QAACmtJREFUeF7tXUuS3DYM7c4uR7IrXsTX8iSLeHwtZ+GUfawJuzGGMeAP/Ipiv66uqR4JBMCHJwiiKOr6/dv3Cz5AYC8E3n94f3XMfvfHu736hd48NAJfPn95+vvpldk//vvx0GCg8xsh8PXfr47Zv23UI3QFCPxC4E3Ofv/hK7ABAudF4Pu3j855ytkBZr+8fNJ9u14vLy8X99d93A/3oS33z/X65bxYwPOdEChktiDxKwpvt4DZO5Ej25dA4ou3uV6vLz8zYFbzPUu67Pl8z59eek1aoVYlzGYSc9qm5C3cBbMtMdtGxnHOON5AVYFjdpE8M7uilWR27gqSixCKTPL4c32W34pYUnPVMLixVHmLEm7booTyUFEqKu3j4vJujDn2HeF5jtnEZlln+8XJW79cCqcs3iuKrHBE/4t0Vngi2VzRvMi9XYXpeJC987f4fU8xmyJx+16e5d97PfS66xRo8jHW62A7Ra8XdNLdFvS/WT/pNjmTm35k751Hme24Szx4ubhS6V5m/PxBu+hrLLL9KiVdushUp4oBbsiI1FVBwValXqkCI1aMvSIpqpFSQLLh31uAyW2ktUMjU43cuEsJmzP3ndYJQnOwpYzM8Spx+qULCSRMyCYsHJNXAr5134FsQRXTGeum8i3rUsdabhvGc5LOZmvqcqYa4esemWM4nfMPCV+QFn6ipSYxOmZpvU7AZPUc66bdW+M50K5wG0lVjWT7FWU25zbCmuOXpnXQXjat+q1UZs12IyugyoasfIVARTcrrDxmEy5CVM2dQCNTjfyqtn/WiFSKBLN1L9D98qBas2RbtsaoszLhmKlzbEIrfxRvhFFVWxvJnWJ2LHGm62C/zmam2jOxndwVyiX6wauC4EZVcXGdxjVV0JNgR5Tk41QgwfHs7MFAwylSzN/iK4nOG5FVR6xaIJl1ApO99FSc9gv9Ig3ZkGwp4CAqujt41D3IPLNj4UlTf1pQgyMtFutBEoPZWegcRG5qf1aMBOjuepE8312vaGWdN8LJOD1Ot07ONsINsTYEntqaZ1vf5ja5gyIr91agdEbUvXVwOJb1gtmFMYD4KAQyM6L4dgP/UI4ogVFuQi8QaEAAz0E2gIemSyIQfaZmqLd0vsAHCIxDAE/4jsMWmo9HwDA/+3gn4QEQKEYAzC6GDA1OgQCYfYowwcliBPLzs6XK9EySYuNoAASGIYCcPQxaKD4UgUpmB6fYU0Z/5Fmdh4YSxt8gkGe2fJqGmvIUbX+W9oTZ2wggELAgkGe2vJfOGkuf/rK4Ahkg0BGBPLODxoJ07+gWVAGBRgQqmS2Tt2XwpNFLNAcCpQjUMJvKa/qqKay8C1NbSyMB+b4I5J/wlfaYr2qCq+QxP0jb11FoAwJFCNTk7CIDEAYChyDQk9moQA4JIYwGEejJbEAMBNZBAMxeJxbwpCcC535azK3MYly/sCdm0LU2AoGnxZzDJ3rrKb3Qsug1KGtHBN61IkBL/ESZbVwBqNWL5vb8GpRmTVCwCQKS2aizNwkquqEQALNBiT0RALP3jCt6BWaDA3sioEf93NgIriD3DLXXK/tip2sC8ukv/epQjI2sGanZXtGw6Wyrney5+xj+CHX/sRH/RZQV/islFRrQpAIBd0NghU/wVZGxjZZudqiz6UYgeGmBe1WZp6t7NfPlsL8Ei8vBlq+7j2GBsQOzY2bUK4T5HSUkL48ElsThYYlZd5n7JE331s/fD/r76w0KrpzIfo3dH8VsSuScy/nfWHan6R+YBGIMW18x+5ux+tolbYOstzKb5yQpyk7m6P1kWvDx5XlLqaoCq71Fe7l67MT6QdZbmU11hSo8ekcQ+sYiILOmyqDBhFqRZbmJ37ZCmwWOJmbLGkPWHqqMTvvRvbZ2mYw+0q7cQrukQHBLUEMsTWaNkjMxx3xnWF7+SPfCEu+gjHzVlr86kt+kIssmmlRos/S0idkJA1ScqFoluEXWLe0sd7HnMSxZYNBG2kITX+X0V7WFlfgaWIk6bLJGidbSDbklqFbBq5r7vbDEOyiTzZpqRTuV43nVO1buL7SUMOHvqnshqupaE7P9YlpeCKoXrfLYJHvAAtxqdHVunMxtFBOBvB0qsY+vrVQ/aa5rZaF7OmsmVrQL7kosjpc+Y0hiKMkKYjQx24LafJlgYdDuRlrtIKPtbls0cNIliquCxFItqGU5LEZlgvflJZUraO0UbshseUetCOK0cEKtLIE6WpymStbZXZbSjS37aMzZJNY4ELwhsxm+xNBeC2kSY23BXYPcaOmCasuVbuwNoEW2ZDViaZgoweuyNRndjdl0KUYfLkx5oyxViwgXVCvOp69G1VVp1o20t4lDKHH0WsikZKj8UBVFYpzON9EyOGipdio6tQmzFaWocpBwqC0JAX/MhPRwNRJEmRX6niTciKn1K5+gV34vKhhw90FPB5V6Ems1BneVru2YHZmp69QmzK7rPFoRAsGlGPlq0hfILuPICuVCkGzLP2OMCASYPQLVk+mszpp8paiKmaL+V1tPW9HP1BinCBa5Pk4Y6420YMsLttwL+ucWVW1tb4vGuCl+xue5aDWO7JMHb5jdfguwrYc1rcfdv6jx5lRtxFJEbmb260UkZd/Jf91x5Zhtz6oWZt9GDR056HagvHDB7+0ReP7nlqcX6WZpTgjSlWhM/XqTs0+09FkpEJD3EXA5++OfH8+LTPo5SDD7vJGF5xqB/k/4AmMgsBoCGPVbLSLwpw8CYHYfHKFlNQTA7NUiAn/6IABm98ERWlZDAMxeLSLwpw8CYHYfHKFlNQTA7NUiAn/6IABm98ERWlZDAPcgh0Tk7EtTDwHlcvFXvO5rSN6DxIyoITOCaFIOPhKBCVPu5IwoVCMD6TfkoDmt0oFAh1SD2ZMBh7lJCIDZk4CGmckIgNmTAYe5SQiA2ZOAlmZiq7zGFuLxV3A9wOmzmZzHbF7gxhInyyIyjVBPMBH0MGg3tpiJXFftKIcbcT6q+Txmux7Ky/rD47TIo8FyLaujSLCl3anMjiFYuswpHRV+7o9tyS63l3agY+CDPJ5mvWNH1ld1PLPTJ9zYXt7OrE1soeXzEscVn0wOOZMca319jtZ5OJXZstRmd9NVQWxvolVLmdHSNhuAYMIeajHr0sYCU5ntL8RIyJZWI/Z4WE70lNEt17V2u+m6i7rcrg0aEghMZXZsrCCxzKmsRioCGTuWlKo59YDsJqdqULwirJYmxzObvUzH2M6A7PWiwsWu2QJoqYw8Y/h0D+4tNfGY8lOZLetsjiIHL1hxpvfKmPmSRloYxTryQ/XUP2VJgcQJraNL+6max2xZGARD68CVdJeXmLQ9tteXVFtix4xFbL+QP0iP5jH7QQBFNxdBAMxeJBBwozMCYHZnQKFuEQTA7EUCATc6I4AnfDsDSurOvjT1EFAul9ELtMsnfMHsQUGE2gMQwPrZB4AOk5MRQJ09GXCYm4QAmD0JaJiZjACYPRlwmJuEAJg9CWiYmYyAfofvZPMwBwS6I0Av+UXO7g4sFC6BwC1n298KvITLcAII5BBwOTsngv1A4JwI/A/hDqODJYAtggAAAABJRU5ErkJggg==)![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJwAAAA8CAIAAAAcxkT0AAAAAXNSR0IArs4c6QAABOJJREFUeF7tXFFS3DAM3fRWMOWn1yrTjxautf2gA8faKisQQrItObGTTaJMJhOysmS/5yd7HS/D68vrKY4dIXD/cH8CUi9x7AWBp99P0D8HIPXu+93bv7cdddbjNuX89/z46/HbcQHYb8u/KPX+4bzflu68Za8vP6CFqNQEqZfLTwnAMJwulxNc4YCbMW1fn1yPYXjeOWBbaF4lqYy/99Z9fRKktiU9Iap8gGFU2jg54qRaYyrxhzLFaxydEYB5q+d8/pPOkRaplHWxGR8pt9Ao6Giir+knnTE5unuLVCSSj6k6G3fG8Mh9AlYSxsUEdugnGv4SqTBYvp+np/Hm44qTIzyFR9Jo1cDQuVds2D2u9xGveGMuAmZJBcKQmMvpEbVCN/gRnv5ZEhUhjOkJ7wrJ+2u+UHPyDZNVUXXi1ckouDbS70gbCpSUemU0ySXiTgoWNIjnZWPdaH/vqQBsI6YkTVOj2CAj/aJExEkippuNgLPVaor0azYjSyrpDCVCOjMZPfK8xoR7ggFlXTG+FlwZ6fdzZP34ooK5V2uUp9NcBvY36bAjqIBIjKNOXkuk5pAl/vwkURpH0dOVZC0ecs/40TFpBhbFOKqfJOYf/NUbLugTZwXyuM2RpzBV3dppDNg634Ti8r1eJswu6JuTID64OqsbZh4EgNTc+p8uXkcqZUid+kQ+DKV6qKqxAfFVHXJB3/XqTdCmv4BWVSGMeyBgvKWhJcDcWqAw6FHF8DkHgdijNAe9mysbe5RujpJWFXK8emsVKvwshUCQuhTSC8YJUhcEe6lQQepSSC8YpzT7hZ37C9ZkD6HE8l4/AGETYfLdamLfr8C1X532QGCqDZpU5ypuFSDIXIHUSL9VeG7DOEhdiCd8Mzr/6qlukOpBaa4NcInZcuZVbBfNVStInUuYp7xzw5jpyuknSDWRbGDgVJgZyenH3KMEk+fPoxz1+mOd8dA3VJA+MhvAi2AN/EVuzTKpMNxrrzfgi8pzg2ZK5b+cLyMLls3RhIhUge3yqhWGoyyeBf3RYIzAtlFqjiSOb06X+DzJBFde0hUpnncUuBfGQsEUMVkl/lDUTf/ZNjcIhQmqcrwKM5pnmcrpOKYiH1q+JL4JyiNvOQWbznMG+Bx7YfPc4FQYZ0sz2lKpnyNqo1FN0Ez6I1jNnlgw8DvXlnPilss6x0JykmS0pVL5mNqv2Tflmfpxq1pVKRUZTRZx+umYflshwv1MyNgTqtG8H1cplRYoNIVOPyuQqonBDKxHXz0zmjDBzjn39A+PjafTCHqEEAvJ1vzCk4xuk8rHVMIUkfJMEXMUOkdQHkjPhLECVUyTw1ypXEQPeTkbrTDkFc+C/gT9bZQq/r0br7TOUZxytEQbUSr5vDz30X7IiWCa/BSYztWKl01GnMxrciyk76ncbZJ+PoHy1MFWqsfLTJtatVWFE86TiafK4QRjp8JMz04/N0FqVf40Wy4MdKqgHFPrarK9c9Zq+nf6uQlSzcZs3YCGRmRl8nVLSt06Z576z3yTCiGcjIJlbDzzMOK10XuU/D9K9Ma42pX3KAWpVWAaxoJU5xA4rQYTdxNOCxalVkQgfiC1Ivh9Q8fsty++q3gPUleBvW/QILUvvqt4D1JXgb1v0CC1L76reB+/p8I8eJXYEbQHAtf/rBTH7hD4D7N9zkc59VX4AAAAAElFTkSuQmCC)

## Creating the Basic Application

1. Create a new java file called BankingFrame.java. Save it in <LAB_HOME>\\labs\\WindowProgamming.
2. In this file declare a class called BankingFrame which will extend JFrame. Remember to include import statements for java.awt.\*, javax.swing.\*, and java.awt.event.\*.
3. Add a constructor to your file, which in the first line needs to pass a title 'Banking Application' up to the superclass constructor.

. Define some instance variables for the application. These will comprise the following;
    1. An array of type Account called accounts.
    2. A JTextField called display.
    3. A JComboBox to represent the choice of accounts.

![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJwAAABfCAIAAACSpjkAAAAAAXNSR0IArs4c6QAABO1JREFUeF7tnFFu2zAMhuO97RbrMVpsD+tNhh6j2R625Frdw4b2GN0t9uip0UAIlCxRCq3IzB8YwWDLFPl/Imk46qbnX887fGwp8M5WOIjmTQFANbgOABVQDSpgMCRkKqAaVMBgSMhUQDWogMGQkKnXCvXu0114eBncmf56qEyqYqR/7PIZpZnq3ibSsQlRYifHd1vLQylU+TLByIsroACVKjMFs3QmM4BdKo4UTsr0DVPBWyhO5BtNcXBxDJuL+lds+fw1MUl+pWFlwd/iTrp/+G/qsswaG1O8hawtjcyfD90IHWPu+XDkUYTgkyHHIgjPZNw4B600U8OeGi///EL2QlAAybXvbcpHxplBXkmWaTwmY7BqLsnsVa420JVCzZhmvP0i9UfofZjumSVCXAlzbM3jT55vkCA/UTKc5ln63KgANaxOSacpTVkZp77CLDCuVDwzxsNL8SxVUlbdXowonrrKfpXnNFjaU5P1itoSLfYYQDgm7L7slpgrMxW2wHA1ZGwutdXkcwBpnYyUFcx4sPwMdeUlN6oKeJK6CGrbesFdl1JAs/xeKgbMyxQAVINLAlAB1aACBkNCpgKqQQUMhoRMBVSDChgMCZkKqAYVMBgSMtUgVOm73w6/LSiqO8/zy+8XRYPbMlUB9fD9sInY7j/f3368BdQyLJepDurj18fyUO0RVXj871lXDrW6p07TtNvtO36/rREHSXI8/XzSXlGbtFdXfk+Z6oi+7xPrPP/d7Q4uU4WZ56Duv+2RqQ2ZevRE5/nRH22AJTdO0/+52qZI3kW7yPKPfis9GK5klkVaDdXDcN9OcX9I8LRRWcky7VjrI3EY+/lbVSRKVkONs2eNfPKur2dZIs12x1RDzWcPq8lhfU6W63wBXylT82WZXWWbfn1y5/c504DMXkNmQXcBVUP12eOrbowkrsmUbfElquFL8JKZGjbFtvpJFtjOZF+Wmc24VtNOYALMxoRbhZMeMgu6RJ21aqgEINlTM09P8aVidU3CZiQaFEn2VJaRZDY+n+mL4X7VTC7S0lmpxVZDzZAIn56Y1plLGSpLc3ktFBUJcyv0Z+l8cSUV/4AguWG9aFY4oBoqPf0KJzhnWKanKhI9x8O4ARfP+I7rF2Vb+yg6XA017qlh11wqv0s9OO9fsT4Xw8s/E9HK8PrGBXPpfGg2HEMlJNm26S66ZaWliTdKbQtj6LtaMvX09m7f4Zsy9fjj6F4BFo+hle7oXEOmdvTuNNXpx4OKD979VkBdqQFU4BIPFf4AILa3sYFSqE6mbUVW9SvstkIreiuFWjSEAeMoUP2gNI7r8GRJAUA1uDYAFVANKmAwJGSqQahdn36vdrffw5eH1z+v3ZZPb6hut1+32AaZyL20uflw0xPqBcqv+5uIq/r0X1sXgNo/yGubEVANEgdUQDWogMGQkKmAalABgyEhUwHVoAIGQ0KmAqpBBQyGhEwFVIMKGAwJmQqoBhUwGBIyFVANKmAwpN47H9z/MWdQxVJInXc+dIXqYiuFb/Z6z+0sXaGaJTZYYHhQGgyIhjuAqqHiYDYAdTAgGu4AqoaKg9kA1MGAaLgDqBoqDmYDUAcDouEOoGqoOJgNQB0MiIY7gKqh4mA2AHUwIBruAKqGioPZANTBgGi4A6gaKg5mA1AHA6LhDqBqqDiYDUAdDIiGO/8ANuSgltT44SgAAAAASUVORK5CYII=)

Figure 1 BankingApplication Part 1

1. Within the constructor, create and populate your Account array. Use three names and balances of your choice.
2. The layout of the container is BorderLayout. For now, you will use FlowLayout, so add a call to getContentPane().setLayout(new FlowLayout()). This will mean that your components will appear from left to right.
3. Now instantiate and display your components as shown above. The JComboBox should use values from your array of three Account subclasses. You will need to use JLabel objects to place text on the display.
4. Set your text field so that the user cannot enter text.
5. Remember that frames are of zero size and are invisible when created, so finally in your constructor, you will need to call pack(). This sets the size to the optimum based on the components present.
6. Fix any errors before proceeding.

## The main method

1. We now need to add a main method to enable you to run this application. Inside this method you need to instantiate a BankingFrame and call setVisisble(true) on it.
2. Compile and test your application. It should all work! But with no event handling.

```
public static void main (String\[\] args) {
    JFrame f = new BankingFrame();
    f.setVisible(true);
}
```


## Part 2 Changing the layout

Currently, the layout is FlowLayout, as this is the simplest layout to use. You are going to modify this to use BorderLayout, and generate an output as shown below in figure 2. To do this will require us to use JPanels and place them into the regions within the BorderLayout.

![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANoAAABfCAIAAAABAk7nAAAAAXNSR0IArs4c6QAABVZJREFUeF7tm01u2zAQheuiB2mOUaNZxDcpcoy4WRQ5l7NIYB8jvYk7ANEBQUr8s0TqTZ6hhUtxyDfzvpCU7e7Ob+cvfLEC26jAjjhuw4hGFfv7fWPkiLDr9Xp5vyRmJo4jbFluTsHx5c/LcuOtONLh4fDj5w/iuGKJhw/tcHz6/dRfSRqsQI/olH04i+PX/mlwRjMVELxKrtPrqTBl4lhYKHabroCskdmrvHYZHGWN9S837pDj8yKTLjJIeXGH9Nz9f7XNLtFtgYtE5VdH2fL1grAzFrl92UspFJjk6dW9xoLVRmcex7ZxGTW8AkLkcA21Am7CUfdxnXWuJdEhuJXtWThp/GRXO5E7lrgrm2CiT3BLTzvxyLXmlfcPdnD3Txc+ubn7Hcpnub3nt+wQfjX9z8zdo7sL1/dBi7a7N5MhwQjpnvEIaRmaXSw1K0li59LRlAv1xEUOKuPPlXUk0cHfo/3VUd+73VxG0Jb4lvbRNyWSgvNG29cr+dXRPzvGS0568XAIBr4GIW7M8p7xihUzlyhfXKbEgFVzVRlQ1bmEBu0zeXZMPN/Et9p2eT+j5uzyOKatVVh1wXAtPiLB+uqH+IMrkQroZM/En0eVbb7CyYncAhak0zbF2Cj/+SZQkrjVoNn53syixN6EoyqeezDUpTHuELSU90xMOiejsLJV4dmMJjfoQiXN3YY/Td/ComSdPzvOlcZfzPTPIj5A+Jt1HBIvovFQc2vtXM/gkKongclKlUiaXOnTs+sCH5xD5oiPNbcROXl2THzos7XPg/gTijbftxIlfA/8zjr7HbQrk3xJeHw+yp9ctj9x3ApYbTrG4lj+ZTRxbPMXLGogjrXnVK6OYGw1yPU/+GwI7xzCzbpzwXtPJwb3nvK2+fjz29vqx+iOFVjmc8eOgjmV5QoQR8vuwuVGHOEssyyYOFp2Fy434ghnmWXBxNGyu3C5EUc4yywLJo6W3YXLjTjCWWZZMHG07C5cbsQRzjLLgomjZXfhciOOcJZZFkwcLbsLlxtxhLPMsmDiaNlduNyII5xllgUTR8vuwuVGHOEssyyYOFp2Fy434ghnmWXBxNGyu3C5EUc4yywLJo6W3YXLjTjCWWZZMHG07C5cbsQRzjLLgomjZXfhciOOcJZZFkwcLbsLlxtxhLPMsmDiaNlduNyII5xllgUTR8vuwuVGHOEssyyYOFp2Fy434ghnmWXBxNGyu3C5EUc4yywLJo6W3YXLjTjCWWZZMHG07C5cbsQRzjLLgomjZXfhciOOcJZZFkwcLbsLlxtxhLPMsmDiaNlduNx257cznOiBgk+vp4GzD5z68dfjx9+PtQUQx7oKC47H52NdDH5vWbPuvt91wJGbdQss10/2aqlRUwxxbCobg9apAHFcp64ctakCxLGpbAxapwI9cNzf7/VKZCF91shxpWHXkMoxe+AoVZZHM3f1h4OfZAFR3glHoIpQ6sAKjMRxbgcP2t2C6hq1UnFsYjQXFYwwsOiceq4CnXBUVvytc24Hj9sl3N/r9Z+6+8ctQcLBCARimxXohOMkeYWrozt6zpVPb6WflhRcHiW3CaJT1QnHuAT+eubfnWvPFlGJnwNuyINUVjY7+BUYhuNSNsSP6pMP766RRC5V9pXG6YRjfHZ0ZMSPF3Ptfv5+H7cWxi1BvbQDN+uVSFpkWP6ip66M7hc98guKujDw3pf3C3/RA+4h5ddXoNNmXS+MEZ+xAsTxM7q+2Zx5dqyzRs6Oh4dDXYyJ3n3OjsSxDhZxpS7AUO8O/zmBOBriBT8Vnh3xPTSUAXE0ZCZ+KsQR30NDGRBHQ2bip/IPZ6gX4azEcZsAAAAASUVORK5CYII=)

Figure 2 BankingApplication Part 2

There are no explicit instructions for how to do this. But you will need to create some JPanels and add the components to the JPanels, and to add the JPanels to the Frame.

Check that the application still works as expected with the appropriate layout.

# Event Handling

## The Aims

In the last lab you were creating a graphical user interface for a Java application to enable a user to access various functionality of a banking application. We will now add event handling to make it work.

Remember, there will be three stages to building in event handling.

1. Implementing the appropriate interfaces
2. Registering your frame with the components to listen for events.
3. ![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANoAAABfCAIAAAABAk7nAAAAAXNSR0IArs4c6QAABVZJREFUeF7tm01u2zAQheuiB2mOUaNZxDcpcoy4WRQ5l7NIYB8jvYk7ANEBQUr8s0TqTZ6hhUtxyDfzvpCU7e7Ob+cvfLEC26jAjjhuw4hGFfv7fWPkiLDr9Xp5vyRmJo4jbFluTsHx5c/LcuOtONLh4fDj5w/iuGKJhw/tcHz6/dRfSRqsQI/olH04i+PX/mlwRjMVELxKrtPrqTBl4lhYKHabroCskdmrvHYZHGWN9S837pDj8yKTLjJIeXGH9Nz9f7XNLtFtgYtE5VdH2fL1grAzFrl92UspFJjk6dW9xoLVRmcex7ZxGTW8AkLkcA21Am7CUfdxnXWuJdEhuJXtWThp/GRXO5E7lrgrm2CiT3BLTzvxyLXmlfcPdnD3Txc+ubn7Hcpnub3nt+wQfjX9z8zdo7sL1/dBi7a7N5MhwQjpnvEIaRmaXSw1K0li59LRlAv1xEUOKuPPlXUk0cHfo/3VUd+73VxG0Jb4lvbRNyWSgvNG29cr+dXRPzvGS0568XAIBr4GIW7M8p7xihUzlyhfXKbEgFVzVRlQ1bmEBu0zeXZMPN/Et9p2eT+j5uzyOKatVVh1wXAtPiLB+uqH+IMrkQroZM/En0eVbb7CyYncAhak0zbF2Cj/+SZQkrjVoNn53syixN6EoyqeezDUpTHuELSU90xMOiejsLJV4dmMJjfoQiXN3YY/Td/ComSdPzvOlcZfzPTPIj5A+Jt1HBIvovFQc2vtXM/gkKongclKlUiaXOnTs+sCH5xD5oiPNbcROXl2THzos7XPg/gTijbftxIlfA/8zjr7HbQrk3xJeHw+yp9ctj9x3ApYbTrG4lj+ZTRxbPMXLGogjrXnVK6OYGw1yPU/+GwI7xzCzbpzwXtPJwb3nvK2+fjz29vqx+iOFVjmc8eOgjmV5QoQR8vuwuVGHOEssyyYOFp2Fy434ghnmWXBxNGyu3C5EUc4yywLJo6W3YXLjTjCWWZZMHG07C5cbsQRzjLLgomjZXfhciOOcJZZFkwcLbsLlxtxhLPMsmDiaNlduNyII5xllgUTR8vuwuVGHOEssyyYOFp2Fy434ghnmWXBxNGyu3C5EUc4yywLJo6W3YXLjTjCWWZZMHG07C5cbsQRzjLLgomjZXfhciOOcJZZFkwcLbsLlxtxhLPMsmDiaNlduNyII5xllgUTR8vuwuVGHOEssyyYOFp2Fy434ghnmWXBxNGyu3C5EUc4yywLJo6W3YXLjTjCWWZZMHG07C5cbsQRzjLLgomjZXfhciOOcJZZFkwcLbsLlxtxhLPMsmDiaNlduNx257cznOiBgk+vp4GzD5z68dfjx9+PtQUQx7oKC47H52NdDH5vWbPuvt91wJGbdQss10/2aqlRUwxxbCobg9apAHFcp64ctakCxLGpbAxapwI9cNzf7/VKZCF91shxpWHXkMoxe+AoVZZHM3f1h4OfZAFR3glHoIpQ6sAKjMRxbgcP2t2C6hq1UnFsYjQXFYwwsOiceq4CnXBUVvytc24Hj9sl3N/r9Z+6+8ctQcLBCARimxXohOMkeYWrozt6zpVPb6WflhRcHiW3CaJT1QnHuAT+eubfnWvPFlGJnwNuyINUVjY7+BUYhuNSNsSP6pMP766RRC5V9pXG6YRjfHZ0ZMSPF3Ptfv5+H7cWxi1BvbQDN+uVSFpkWP6ip66M7hc98guKujDw3pf3C3/RA+4h5ddXoNNmXS+MEZ+xAsTxM7q+2Zx5dqyzRs6Oh4dDXYyJ3n3OjsSxDhZxpS7AUO8O/zmBOBriBT8Vnh3xPTSUAXE0ZCZ+KsQR30NDGRBHQ2bip/IPZ6gX4azEcZsAAAAASUVORK5CYII=)


Figure 3 BankingApplication

## Part 1 Implementing the interface

You will be capturing events from the JComboBox component. This generates ActionEvent objects. The interface for ActionEvents is ActionListener. You will need therefore to implement this interface. Remember to also import the java.awt.event package.

## Part 2 Registering the Frame as a listener with the JComboBox

You will need to set up the Frame to be a listener for ActionEvents from the JComboBox. This involves a method call to the JComboBox object. The method is called addActionListener(..). What parameter needs to be passed in the brackets?

## Part 3 Implementing the method from the Interface

Now you need to implement the method found in ActionListener. When you first start using these interfaces, it is not easy to remember all the methods involved. If you compile your code now, you should get an error, and that error will tell you the name of the method. Place that method in your applet, and in it, set the balance to be the value of the balance for the account selected. This will involve calls to the JComboBox object’s getSelectedItem() method. You will also need to use the JTextField’s setText() method.

Now compile your class, fix any errors, and launch it in a web page to see your results.

# Optional Extension for Event Handling – Using Inner Classes

## The Aims

In the last labs you created a graphical user interface for a Java application to enable a user to access various functionality of a banking application. The event handling was carried out by your top level container, the frame. We will now modify our application to use an anonymous inner class to handle events from your JComboBox component.

Optionally, we will then enhance the functionality of our interface to enable users to deposit and withdraw cash to and from the accounts.

1. If you wish, copy your files from the last practical into a different folder so that you can refer back to them if you need to.
2. Remove the ‘implements ActionListener’ as the frame is no longer going to be listening for ActionEvents. This will be done by the anonymous inner class.
3. Now modify your call to addActionListener(this) on your JComboBox reference by removing the reference to this, and place in the brackets an anonymous inner class.


```
combo.addActionListener( new ActionListener() {
        public void actionPerformed (ActionEvent evt) {
        //the logic goes here
        }
});
```

1. Lastly, remove the actionPerformed() method from the frame.
2. Recompile your code and check that it all still works. Notice how many class files are now located in your code directory. There should be two. One is called MyFrame.class, and there will be another one with the name MyFrame$1.class (developer tools show this information from the File view or File tab).

## Optional Extension

We can now extend our application to deposit and withdraw money. There are no explicit instructions to do this, but if you chose to do this, you will be drawing on knowledge built up from the previous chapters.


## Adding a Menu

We will create a menu which enables the user to get an “About” dialog box. This will be found in a menu called “Help”.

1. Declare instance variables to represent a JMenuBar, a JMenu, and a JMenuItem called mBar, menu and mItem respectively.
2. Within your constructor, create your three components. Pass in the string “Help” to your menu and pass in the string “About” to your mItem.
3. Add your JMenuItem to your JMenu, add the JMenu to your JMenuBar, and set the JMenuBar for your Frame.
4. Compile and test your class. You should now have a menu.

## Adding Event Handling to your Menu

1. You will need to register an ActionListener with your JMenuItem. As before, this can be an inner class or the event handling can be done by your BankingFrame.
2. The actionPerformed() method will be empty at the moment, as we do not have a Dialog box to instatiate. We will provide the code for that next.

```
mItem.addActionListener ( new ActionListener() {
    public void actionPerformed (ActionEvent evt) {
        // create a dialog
        BankingDialog b = new BankingDialog(_BankingFrame.this_);
        b.setVisible(true);
    }
});
```

## Creating the Dialog box

We will define our Dialog box class within our BankingFrame java file.

```
public class BankingFrame {

}

class BankingDialog {

}
```

Note that the class is not public. A Java source file can only contain one public class. The class called BankingDialog has package scope.

1. Define your class as above called BankingDialog. It will need to extend JDialog.
2. Within the class add a constructor that takes in a reference to a Frame. This will be the parent frame of the dialog box. Dialogs cannot be created without a parent Frame.
3. Within the constructor, place a call to super as the first line, passing up to the superclass the Frame reference, a title, and a boolean value true. This will make the dialog box modal.

```
public BankingDialog (Frame f) {
    super (f, “About Banking”, true);
…
}
```

1. Now within the constructor, create and add a JLabel which states the author of this banking application (you!). Also create and add a JButton which will be used as the OK button to dismiss the dialog. Remember, the layout manager here is BorderLayout. You need to modify it and set it to be FlowLayout. This will give your components an appropriate size and location.
2. We will need to add event handling to the button by registering a listener. This can be your dialog or an inner class. The interface is ActionListener and the method is void actionPerformed(ActionEvent evt).
3. Within the method, we need to call dispose on the dialog box. Do not call System.exit(0), as this will exit your application.
4. Finally, remember that Dialogs, like Frames, have zero size and are invisible upon creation. Call setSize() or pack() on your dialog.
5. Earlier in the lab you added an empty actionPerformed() method to respond to action events from your JMenuItem. Now from there you can create and show a dialog box. The code will look something like figure 3. Note the reference to ‘this’. In this inner class, a reference to this would refer to the inner class object, not the BankingFrame outer class. To force it to refer to the outer instance, we refer to it with OuterClassName.this.
6. Compile and run your code. You should now have a menu with a functioning about box.