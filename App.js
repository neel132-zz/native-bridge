/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  Text,
  StatusBar,
  Button,
  TextInput
} from 'react-native';

import {
  Colors,
} from 'react-native/Libraries/NewAppScreen';

import Sample from './bridge';

const App: () => React$Node = () => {
  const [value , onChangeValue] = React.useState(0);
  const [data, setData] = React.useState([''])

  const showData = async () => {
    let response = await Sample.show(parseInt(value));
    setData(response);
  }

  return (
    <>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView style={{margin: 15, }}>
      <TextInput
          value={value}
          onChangeText={text => onChangeValue(text)}
          placeholder="Enter decimals count"
          style={{paddingVertical: 15, }}
      />
        <Button title="Calculate PI value" onPress={showData} color="teal" />
        
          <Text style={{ fontSize: 16, fontWeight: '600'}}>
              {`Value:  ${data[0]}`}
          </Text>

      </SafeAreaView>
    </>
  );
};

export default App;
